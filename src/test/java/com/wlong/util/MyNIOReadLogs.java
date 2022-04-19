package com.wlong.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyNIOReadLogs {
    public static void main(String args[]) throws Exception {
        //拆分每个文件的大小,也是一次性读取的文件内容
        double bufSize = 20971520.00;//20MB
        String filePath="C:\\Users\\hnjz\\Desktop\\logs\\zzzw\\155\\";
        String fileName="catalina.2022-04-17.log";
        String fenFileNamePre=fileName;
        File fin = new File(filePath+fileName);//读取的文件
        if(fileName.indexOf(".")>-1){
            fenFileNamePre="";
            String[] splitOldName=fileName.split("\\.");
            for(int i=0;i<splitOldName.length-1;i++){
                if(!"".equals(fenFileNamePre)){
                    fenFileNamePre=fenFileNamePre+"_"+splitOldName[i];
                }else{
                    fenFileNamePre=splitOldName[i];
                }
            }
        }
        File fileDirFen=new File(filePath+fenFileNamePre+"_fen");
        if(fileDirFen.exists() && fileDirFen.isDirectory()){
            fileDirFen.delete();
        }else{
            fileDirFen.mkdir();
        }
        //long fileSize=fin.length();//Byte
        //向上取整
        //double allSize=Math.ceil(fileSize/1024.00/1024.00);//MB
        //int allPageNum=Double.valueOf(Math.ceil(allSize/bufSizeMb)).intValue();
        FileChannel fcin = new RandomAccessFile(fin, "r").getChannel();
        ByteBuffer  rBuffer = ByteBuffer.allocate(Double.valueOf(bufSize).intValue());
        readFileByLine(fcin, rBuffer,fileDirFen.getPath(),
                fenFileNamePre,Double.valueOf(bufSize).intValue(),0);
        if(fcin.isOpen()){
            fcin.close();
        }
    }

    public static void readFileByLine(
            FileChannel fcin, ByteBuffer rBuffer,
            String fileDirFen,String fileName,int bufSize,int startPage) {
        String encode = "UTF-8";
        try {
            while (fcin.read(rBuffer) != -1) {//fcin.read(rBuffer)：从文件管道读取内容到缓冲区(rBuffer)
                File fout = new File(
                        fileDirFen+"\\"+fileName+"_"+(startPage+1)+".txt");//写出的文件
                if(fout.exists()){
                    fout.delete();
                }
                fout.createNewFile();
                FileChannel fcout = new RandomAccessFile(fout, "rws").getChannel();
                //ByteBuffer wBuffer = ByteBuffer.allocateDirect(Double.valueOf(bufSize).intValue());
                int rSize = rBuffer.position();//读取结束后的位置，相当于读取的长度
                byte[] bs = new byte[rSize];//用来存放读取的内容的数组
                //将position设回0,所以你可以重读Buffer中的所有数据,此处如果不设置,无法使用下面的get方法
                rBuffer.rewind();
                //相当于rBuffer.get(bs,0,bs.length())：从position初始位置开始相对读,读bs.length个byte,
                // 并写入bs[0]到bs[bs.length-1]的区域
                rBuffer.get(bs);
                rBuffer.clear();
                writeFileByBuffer(fcout,bs);
                if(fcout.isOpen()){
                    fcout.close();
                }
                startPage++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写到文件上
     * @param fcout
     * @param wBuffer
     */
    @SuppressWarnings("static-access")
    public static void writeFileByBuffer(FileChannel fcout, byte[] wBuffer) {
        try {
            fcout.write(ByteBuffer.wrap(wBuffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
