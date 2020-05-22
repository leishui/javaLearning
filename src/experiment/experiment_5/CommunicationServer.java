package experiment.experiment_5;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

class CommunicationServer extends JFrame implements Runnable {
    JPanel contentPane;
    JLabel jLabel1 = new JLabel();
    //创建图形用户界面
    JLabel jLabel2 = new JLabel();
    public JTextField jTextField1 = new JTextField();
    public JTextArea jTextArea1 = new JTextArea("hello!", 100, 50);
    Thread s;
    private DatagramSocket sendSocket, receiveSocket;
    private DatagramPacket sendPacket, receivePacket;
    private String name;

    public CommunicationServer() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        jLabel1.setText("通信记录:");
        jLabel1.setBounds(new Rectangle(4, 4, 67, 29));
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        this.setSize(new Dimension(400, 200));
        this.setTitle("UDPServer");
        jLabel2.setText("輪入通信内容:");
        jLabel2.setBounds(new Rectangle(11, 124, 93, 32));
        jTextField1.setText("通信内容");
        jTextField1.setBounds(new Rectangle(118, 125, 269, 30));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jTextField1_actionPerformed(e);
            }
        });
        jTextArea1.setBounds(new Rectangle(97, 29, 380, 90));
        jTextArea1.setEditable(false);
        jTextField1.setEditable(true);
        contentPane.add(jLabel1, null);
        contentPane.add(jTextArea1, null);
        contentPane.add(jTextField1, null);
        contentPane.add(jLabel2, null);
        try {
            sendSocket = new DatagramSocket();
            receiveSocket = new DatagramSocket(8002);
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(1);
        }
        s = new Thread(this);
        s.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte buf[] = new byte[100];
                receivePacket = new DatagramPacket(buf, buf.length);
                receiveSocket.receive(receivePacket);
                name = receivePacket.getAddress().toString().trim();
                jTextArea1.append("\n来自主机:" + name + "\n端口:" + receivePacket.getPort());
                jTextArea1.append("\n客户端:\t");
                byte[] data = receivePacket.getData();
                String receivedString = new String(data, 0);
                jTextArea1.append(receivedString);
            } catch (IOException e) {
                jTextArea1.append("网络通信出现错误，问题在于" + e.toString());
            }
        }
    }

    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            System.exit(0);
        }
    }
    void jTextField1_actionPerformed(ActionEvent e){
        try {
            jTextArea1.append("\n服务器：");
            String string = jTextField1.getText().trim();
            jTextArea1.append(string);
            byte[] databyte = new byte[100];
            string.getBytes(0, string.length(), databyte, 0);
            DatagramPacket sendPacket = new DatagramPacket(databyte,string.length(),java.net.InetAddress.getByName("192.168.0.6"),8000);
            sendSocket.send(sendPacket);
        } catch (IOException unknownHostException) {
            jTextArea1.append("网络通信出现错误，问题在于"+e.toString());
        }
    }
}
class UDPCommunicationServer{
    public static void main(String[] args) {
        CommunicationServer communicationServer = new CommunicationServer();
        communicationServer.setVisible(true);
    }
}