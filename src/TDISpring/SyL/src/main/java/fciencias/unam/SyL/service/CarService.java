package fciencias.unam.SyL.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// QR
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;  
import java.io.IOException;  
import java.util.HashMap;  
import java.util.Map;  
import com.google.zxing.BarcodeFormat;  
import com.google.zxing.EncodeHintType;  
import com.google.zxing.MultiFormatWriter;  
import com.google.zxing.NotFoundException;  
import com.google.zxing.WriterException;  
import com.google.zxing.client.j2se.MatrixToImageWriter;  
import com.google.zxing.common.BitMatrix;  
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;  


import java.util.HashMap;
import java.util.List;

import fciencias.unam.SyL.repository.CarRepository;
import fciencias.unam.SyL.repository.CarRepositoryy;
import fciencias.unam.SyL.entity.Car;
import fciencias.unam.SyL.entity.Carr;

import java.io.File;
import java.io.IOException;
import java.lang.RuntimeException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Optional;

import javax.imageio.ImageIO;
@Service
public class CarService{
	@Autowired
    private CarRepository carRepository;

    @Autowired
    private CarRepositoryy carRepositoryy;
    
    public List<Car> getAllCars() {
        return carRepositoryy.findAll();
    }

    public Car findById(long id){
        Optional<Car> finded = carRepositoryy.findById(new Long(id));
        if(finded.isEmpty())
            return null;
        return finded.get();
    }

    public Car save(Car car){
        car.setDate(java.time.LocalDateTime.now());
        carRepositoryy.save(car);
        return car;
    }

    public boolean delete(long id){
        carRepositoryy.deleteById(new Long(id));
        return true;
    }
    public Car update(Car car){
        return carRepositoryy.save(car);
    }
    public boolean deleteAll(){
        carRepositoryy.truncateCarDB();
        return true;
    }
    
    public String getHostLink(){
        String url = "http://";
        try (final DatagramSocket datagramSocket = new DatagramSocket()) {
            datagramSocket.connect(InetAddress.getByName("8.8.8.8"), 12345);
            url = url + (datagramSocket.getLocalAddress().getHostAddress());
        }catch(Exception e){
        }
        url = url + ":8080/";
        return url;
    }
    public void generateHostLinkQR(String path){
        try{
            saveQRCode(path, getHostLink());
        }catch(Exception e){

        }
    }

    public void saveQRCode(String path, String qrText){
        try{
            QRCodeWriter barcodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = 
            barcodeWriter.encode(qrText, BarcodeFormat.QR_CODE, 200, 200);
            
            File outputfile = new File(path);
            ImageIO.write(MatrixToImageWriter.toBufferedImage(bitMatrix), "jpg", outputfile);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
}
