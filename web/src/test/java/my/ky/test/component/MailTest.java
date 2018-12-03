package my.ky.test.component;

import freemarker.template.Configuration;
import freemarker.template.Template;
import my.ky.test.BaseSpringTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>邮件测试</li>
 * <li>User:ky Date:2018/2/6 Time:9:38</li>
 * </ul>
 */
public class MailTest extends BaseSpringTest {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration configuration;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kriver@qq.com");
        message.setTo("kriver@qq.com");
//        message.setFrom("Pay@oriental-finance.com");
//        message.setTo("kuaiyue@oriental-finance.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");
        mailSender.send(message);
    }

    @Test
    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("kriver@qq.com");
        helper.setTo("kriver@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("E:/face.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendInlineMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("kriver@qq.com");
        helper.setTo("kriver@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:face\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("E:/face.jpg"));
        helper.addInline("face", file);

        mailSender.send(mimeMessage);
    }

    @Test
    public void sendTemplateMail() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("username", "river");

        Template template = configuration.getTemplate("test_mail.ftl");
        StringWriter stringWriter = new StringWriter();
        template.process(model, stringWriter);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("kriver@qq.com");
        helper.setTo("kriver@qq.com");
//        helper.setFrom("Pay@oriental-finance.com");
//        helper.setTo("kuaiyue@oriental-finance.com");
        helper.setSubject("主题：模板邮件");
        helper.setText(stringWriter.toString(), true);
        mailSender.send(mimeMessage);
    }
}
