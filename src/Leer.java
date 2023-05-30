package Leer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.*;


//	String nombreUsuario = "Paco";
public class Leer {

	public static void main(String[] args) throws IOException{

	Path p1 = Paths.get("c:\\temp\\ejemplo");
		
		
//System.out.format("%s%n", p1.toUri());
	
//	try {
//		Path p2 = p1.toRealPath();
		//System.out.println("RealPath: "+p2);
		
		//System.out.println("Valor del Path p2 : " + p2);
		
//		Files.delete(p2);
//		System.out.println("ruta borrada");
//		
//	}catch (NoSuchFileException x) {
//		System.out.println("error");
////		if(p2.startsWith(Paths.get("temp"))|| p2.endsWith(Paths.get("añadida"))) {
//			System.out.println("encontrarse la ruta");
//		}
//		}catch (NoSuchFileException x) {
//			System.err.format("%s: no encontrado" + "fichero o directorio", p1);
//		}catch (IOException x) {
//			System.err.format("%s%n", x);
//		}
	
		//System.out.println(p1.resolve("añadida"));
	
	System.out.println("Propiedades de un Fichero");
	
	Path p3 = Paths.get("c:\\temp\\ejemplo\\fichero.txt");
	BasicFileAttributes attr = Files.readAttributes(p3, BasicFileAttributes.class);
	
	System.out.println("Fecha de Creación : " + attr.creationTime());
	System.out.println("Última Fecha de acceso: " + attr.lastAccessTime());
	System.out.println("Última fecha de modificación : " + attr.lastModifiedTime());
	
	System.out.println("isDirectiorio: " + attr.isDirectory());
	System.out.println("isFichero" + attr.isRegularFile());
	System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
	System.out.println("size: " +attr.size());
	
	
	long currentTime = System.currentTimeMillis();
	FileTime ft = FileTime.fromMillis(currentTime);
	Files.setLastModifiedTime(p3, ft);
	System.out.println( " Última fecha de modificación : " + attr.lastModifiedTime());
	
	
	System.out.println("********** Permisos fichero ********** ");
	PosixFileAttributes.attr2 = Files.readAttributes(p3, PosixFileAttributes.class);
	
	System.out.format("%s %s %s%n", attr2.owner().getName(),
			attr2.group().getName(),
			PosixFilePermissions.toString(attr2.permissions)));

	GroupPrincipal grupo = p2.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByGroupName("curso Java8");
	
	Files.getAttribute(p2, PosixFileAttributeView.class.setGroup(group));
			
	
	byte[] buf = "esto es una prueba 2".getBytes();
	Files.write(p3, buf);
	
	
	Charset charset = Charset.forName("US-ASCII");
	try (BufferedReader reader = Files.newBufferedReader(p3, charset)) {
		String line = null;
		while ((line = reader.readLine())!= null) {
			System.out.println(line);
		}
	}catch(IOException x) {
		System.err.format("IOException : $s$n",x);
	}
	
	Path p4 = Paths.get("c:\\temp\\ejemplo\\fichero4.txt");
	
	try {
		Files.createFile(p4);
	} catch (FileAlreadyExistsException x) {
		System.err.format("Error, el fichero existe");
	} catch (IOException x) {
		System.out.println("Error de permisos sobre el fichero");
	}
	
	RandomAccessFile File = new RandomAccessFile("prueba.txt", "r");
	FileChannel inChannel = File.getChannel();
	ByteBuffer buff = ByteBuffer.allocate(1024);
	while (inChannel.read(buffer) > 0{
		buff.flip();
		for (int i = 0; i <buff.limit(; i++){
			System.out.println(char) buff.get();
		}
		buff.clear();
	}
	inChannel.close();
	File.close();
	
	}
}

//		int day = 2;
//		String dayType;
//		String dayString;
//
//		switch (day) {
//
//		case 1:
//			dayString = "Lunes";
//			break;
//
//		case 2:
//			dayString = "Martes";
//			break;
//
//		case 3:
//			dayString = "Miercoles";
//			break;
//
//		case 4:
//			dayString = "Jueves";
//			break;
//
//		case 5:
//			dayString = "Viernes";
//			break;
//
//		case 6:
//			dayString = "Sabado";
//			break;
//
//		case 7:
//			dayString = "Domingo";
//			break;
//
//		default:
//			dayString = "Dia invalido";
//
//		}
//
//		switch (day) {
//
//		case 1:
//		case 2:
//		case 3:
//		case 4:
//		case 5:
//			dayType = "Dia laborable";
//			break;
//		case 6:
//		case 7:
//			dayType = "Fin de semana";
//			break;
//		default:
//			dayType = "Tipo de dia invalido";
//		}
//		System.out.println(dayString + " es un " + dayType);
//
//		
//		String Branch = "CSE";
//		int year = 2;
//		
//		switch(year){
//			
//		case 1:
//			System.out.println("Cursos electivos: Ingles, Calculo");
//			break;
//		case 2:
//			switch (Branch) {
//			
//			case "CSE":
//			case "CCE":
//				System.out.println("Cursos electivos: Machine Learning, Big Data");
//				break;
//			
//			case "ECE":
//			System.out.println("Cursos electivos : P^rogramación");
//			break;
//			
//			default:
//				System.out.println("Cursos electivos : Ingeniería de Software");
//
//			}
//		}

//		try (PrintStream stream = new PrintStream ("hello.txt")){
//			stream.println("Hello world!");
//		} catch (FileNotFoundException ex) {
//			System.err.println("Cannot open the file");
//		} finally {
//			System.err.println("All done");
//		}
//		
//		
//		try (InputStream is = new FileInputStream(file1);
//				OutputStream os = new FileOutputStream(file2)){
//			
//		}
//		
//		

//		PrintStream stream = new PrintStream("hello.txt");
//
//		Throwable primaryException = null;

//		try {
//			stream.println("Hello world!");
//		} catch (Throwable t) {
//			primaryException = t;
//			throw t;
//		} finally {
//			if (primaryException == null) {
//				stream.close();
//			} else {
//				try {
//					stream.close();
//				} catch (Throwable suppressedException) {
//					primaryException.addSuppressed(suppressedException);
//				}
//			}
//		}
