package cafe.jjdev.mall.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import cafe.jjdev.mall.vo.Member;

@Component
public class EmailServiceImpl {
  
    @Autowired
    public JavaMailSender emailSender;
    
    public void sendSimpleMessage(Member member, String text) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        
        message.setTo(member.getMemberEmail()); 
        message.setSubject(text); 
        message.setText(member.getMemberId());
        
        emailSender.send(message);
    }    
}
