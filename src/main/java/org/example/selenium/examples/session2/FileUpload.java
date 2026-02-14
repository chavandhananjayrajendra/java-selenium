package org.example.selenium.examples.session2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.manage().window().maximize();

        //single file payload/(Feedback Hub 14_02_2026 12_41_21 pm.png)
        driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]")).sendKeys("C:\\Users\\chava\\Videos\\Captures\\Feedback Hub 14_02_2026 12_41_21 pm.png");
if(driver.findElement(By.xpath("//ul[@id=\"fileList\"]/li")).getText().equals("Feedback Hub 14_02_2026 12_41_21 pm.png")){
    System.out.println("file is successfully uploaded");
}
else{
    System.out.println("Upload Failed");
}
        driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]")).sendKeys("C:\\Users\\chava\\Videos\\Captures\\Feedback Hub 14_02_2026 12_41_21 pm.png");

        //multiple files upload

        String file1 = "C:\\Users\\chava\\Downloads\\login.live.com_oauth20_authorize.srf_client_id=81feaced-5ddd-41e7-8bef-3e20a2689bb7&scope=service3aaccount.microsoft.com3aMBI_SSL+openid+profile+offline_access&redirect_uri=https2f%2faccount.microsoft.c.png";
    String file2 = "C:\\Users\\chava\\Downloads\\IMG_20251227_100136635.jpg";
    driver.findElement(By.xpath("//input[@id=\"filesToUpload\"]")).sendKeys(file1+"\n"+file2);
    //validation->no of files uploaded
    int nooffilesuploaded = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
    if(nooffilesuploaded>2){
        System.out.println("All files are uploaded");

    }
    else{
        System.out.println("Files are not uploaded or incorrect files uploaded");
    }

    //validate file names
        if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Feedback Hub 14_02_2026 12_41_21 pm.png")){
            System.out.println("Files names matching");
        }
        else
        {
            System.out.println("files are not matching");

        }

    }



}
