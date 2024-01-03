package fciencias.unam.SyL.service;


import org.hibernate.mapping.Map;
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
    
    public static void generateQRcode(String data, String path, String charset, Map map, int h, int w) throws WriterException, IOException{
        //the BitMatrix class represents the 2D matrix of bits  
        //MultiFormatWriter is a factory class that finds the appropriate Writer subclass for the BarcodeFormat requested and encodes the barcode with the supplied contents.  
        try{
            BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, w, h);

            MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));  
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }  


    public static void create(){
        //data that we want to store in the QR code  
        String str= "THE HABIT OF PERSISTENCE IS THE HABIT OF VICTORY.";  
        //path where we want to get QR Code  
        String path = "/home/rodriginsky/Desktop/Repos/Parking/Parking/qr.png";  
        //Encoding charset to be used  
        String charset = "UTF-8";  
        // Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();  
        //generates QR code with Low level(L) error correction capability  
        // hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);  
        //invoking the user-defined method that creates the QR code  
        try{
            generateQRcode(str, path, charset, null, 200, 200);//increase or decrease height and width accodingly   
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        //prints if the QR code is generated   
        System.out.println("QR Code created successfully.");  
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
