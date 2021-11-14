package QLKS_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JPasswordField;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/QLKS_IMAGE/office.png")));
		setTitle("\u0110\u0103ng nh\u1EADp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 99, 71));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Hotel Management");
		lblNewLabel.setForeground(new Color(224, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel btnThoat = new JPanel();
		btnThoat.setBackground(new Color(0, 191, 255));
		contentPane.add(btnThoat, BorderLayout.CENTER);
		btnThoat.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(139, 153, 111, 24);
		btnThoat.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(139, 198, 111, 36);
		btnThoat.add(lblNewLabel_2);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTaiKhoan.setColumns(10);
		txtTaiKhoan.setBounds(260, 153, 169, 24);
		btnThoat.add(txtTaiKhoan);
		
		JButton btnDangNhap = new JButton("Login");
		btnDangNhap.addActionListener(new ActionListener() {
			MenuForm menuForm = new MenuForm();
			public void actionPerformed(ActionEvent arg0) {
				if (!menuForm.isActive())
				{
					String user = txtTaiKhoan.getText();
					String pass = txtMatKhau.getText();
					if (user.equals("nhom8") && pass.equals("nhom8"))
					{
						JOptionPane.showMessageDialog(LoginForm.this,
				                "Đăng nhập thành công",
				                "Thông tin",
				                JOptionPane.INFORMATION_MESSAGE);
						LoginForm.this.dispose();
						menuForm.setVisible(true);
						//suForm.pack();
						menuForm.setLocationRelativeTo(null);
						menuForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					}
					else
						JOptionPane.showMessageDialog(LoginForm.this,
				                "Đăng nhập thất bại",
				                "Thông báo",
				                JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnDangNhap.setForeground(new Color(255, 255, 255));
		btnDangNhap.setBackground(SystemColor.textHighlight);
		btnDangNhap.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangNhap.setBounds(136, 261, 293, 54);
		btnThoat.add(btnDangNhap);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LoginForm.class.getResource("/QLKS_IMAGE/hotel.png")));
		lblNewLabel_3.setBounds(231, 32, 123, 84);
		btnThoat.add(lblNewLabel_3);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMatKhau.setBounds(260, 205, 169, 24);
		btnThoat.add(txtMatKhau);
	}
}
