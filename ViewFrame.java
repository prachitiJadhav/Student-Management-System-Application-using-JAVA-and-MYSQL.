import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewFrame extends JFrame{
Container c;
TextArea taData;
JButton btnBack;

ViewFrame(){
c=getContentPane();
c.setLayout(new FlowLayout());

taData=new TextArea(10,30);
btnBack=new JButton("Back");
c.add(taData);
c.add(btnBack);

String data=new DbHandler().viewStudent();
taData.setText(data);


ActionListener a1=(ae) ->{
MainFrame af=new MainFrame();
dispose();
};
btnBack.addActionListener(a1);

setTitle("View Student");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}