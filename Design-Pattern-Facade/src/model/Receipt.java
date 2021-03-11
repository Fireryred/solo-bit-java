package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Receipt implements Facade{
	private ServletContext context;
	private ResultSet records;
	private String email, file;
	private int orderId;
	
	public Receipt(ResultSet records, int orderId, String email, ServletContext context) {
		super();
		this.records = records;
		this.orderId = orderId;
		this.email = email;
		this.context = context;
	}
	
	public void createPdf() throws DocumentException, IOException, SQLException {
		Document document = new Document();
		String path = context.getRealPath("/");
		
		file = path + LocalDate.now() + "SolobitOrder#" + orderId + ".pdf";
		
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		
		Paragraph logo = new Paragraph("Solobit");
		logo.setAlignment(Element.ALIGN_CENTER);
		
		
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		Paragraph date = new Paragraph("Date: " + dft.format(now));
		
		Paragraph order = new Paragraph("#" + orderId);
		
		document.add(logo);
		document.add(date);
		document.add(order);
		
		PdfPTable orderDetails = new PdfPTable(3);
		double total = 0;
		
		PdfPCell empty = new PdfPCell();
		empty.setBorder(0);
		
		while(records.next()) {
			double sum = 0;
			sum = records.getInt("quantity") * records.getInt("price");
			
			total += sum;
			
			Paragraph sumP = new Paragraph(Double.toString(sum));
			sumP.setAlignment(Element.ALIGN_RIGHT);
			
			PdfPCell name = new PdfPCell(new Phrase(records.getString("name")));
			PdfPCell firstText = new PdfPCell(new Phrase(records.getInt("quantity") + " x " + records.getInt("price")));
			PdfPCell sumC = new PdfPCell(sumP);
			
			name.setBorder(0);
			firstText.setBorder(0);
			sumC.setBorder(0);
			
			orderDetails.addCell(name);
			orderDetails.addCell(empty);
			orderDetails.addCell(firstText);
			
			orderDetails.addCell(empty);
			orderDetails.addCell(empty);
			orderDetails.addCell(sumC);
		}
		
		PdfPCell totalP = new PdfPCell(new Phrase("Total"));
		PdfPCell totalPrice = new PdfPCell(new Phrase(Double.toString(total)));
		
		totalP.setBorder(0);
		totalPrice.setBorder(0);
		
		orderDetails.addCell(totalP);
		orderDetails.addCell(empty);
		orderDetails.addCell(totalPrice);
		
		document.add(orderDetails);
		
		document.close();
	}
	
	public void sendToMail() throws AddressException, MessagingException, IOException {
		Properties properties = System.getProperties();
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(properties, 
			new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("bitsolo27@gmail.com", "FireRed14571003");
				}
			}
		);
		
		MimeMessage message = new MimeMessage(session);
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		message.setSubject("Your Order #" + orderId + " has been successfully paid");
		message.setText("Here's your receipt");
		
		Multipart emailContent = new MimeMultipart();
		MimeBodyPart pdfAttachment = new MimeBodyPart();
		pdfAttachment.attachFile(file);
		emailContent.addBodyPart(pdfAttachment);
		
		message.setContent(emailContent);
		
		Transport.send(message);
	}
	@Override
	public void process() {
		try {
			createPdf();
			sendToMail();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
