package QLKS_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class MenuForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuForm frame = new MenuForm();
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
	public MenuForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuForm.class.getResource("/QLKS_IMAGE/hotel.png")));
		setTitle("Quản lý khách sạn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ CHUNG");
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		Color customColor = new Color(25, 25, 112);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(25, 25, 112));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNhanVien.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNhanVien.setForeground(customColor);
			}
			
		});
		btnNhanVien.setForeground(new Color(25, 25, 112));
		btnNhanVien.setBackground(new Color(173, 216, 230));
		btnNhanVien.setIcon(new ImageIcon(MenuForm.class.getResource("/QLKS_IMAGE/NhanVien.png")));
		btnNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
		btnNhanVien.addActionListener(new ActionListener() {
			NhanVienForm nvForm = new NhanVienForm();
			public void actionPerformed(ActionEvent arg0) {
				if (!nvForm.isActive())
				{
					nvForm.setVisible(true);
					nvForm.setLocationRelativeTo(null);
					nvForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
		});
		btnNhanVien.setBounds(67, 49, 239, 63);
		panel_1.add(btnNhanVien);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.addActionListener(new ActionListener() {
			KhachHangForm khForm = new KhachHangForm();
			public void actionPerformed(ActionEvent arg0) {
				if (!khForm.isActive())
				{
					khForm.setVisible(true);
					khForm.setLocationRelativeTo(null);
					khForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
		});
		btnKhachHang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKhachHang.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnKhachHang.setForeground(customColor);
			}
		});
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(MenuForm.class.getResource("/QLKS_IMAGE/KhachHang.png")));
		btnKhachHang.setForeground(new Color(25, 25, 112));
		btnKhachHang.setFont(new Font("Arial", Font.PLAIN, 17));
		btnKhachHang.setBackground(new Color(173, 216, 230));
		btnKhachHang.setBounds(364, 49, 239, 63);
		panel_1.add(btnKhachHang);
		
		JButton btnPhong = new JButton("Phòng");
		btnPhong.addActionListener(new ActionListener() {
			PhongForm pForm = new PhongForm();
			public void actionPerformed(ActionEvent arg0) {
				if (!pForm.isActive())
				{
					pForm.setVisible(true);
					pForm.setLocationRelativeTo(null);
					pForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
		});
		btnPhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPhong.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPhong.setForeground(customColor);
			}
		});
		btnPhong.setHorizontalAlignment(SwingConstants.LEFT);
		btnPhong.setIcon(new ImageIcon(MenuForm.class.getResource("/QLKS_IMAGE/Phong.png")));
		btnPhong.setForeground(new Color(25, 25, 112));
		btnPhong.setFont(new Font("Arial", Font.PLAIN, 17));
		btnPhong.setBackground(new Color(173, 216, 230));
		btnPhong.setBounds(67, 162, 239, 63);
		panel_1.add(btnPhong);
		
		JButton btnDichVu = new JButton("Dịch vụ");
		btnDichVu.addActionListener(new ActionListener() {
			DichVuForm dvForm = new DichVuForm();
			public void actionPerformed(ActionEvent arg0) {
				if (!dvForm.isActive())
				{
					dvForm.setVisible(true);
					dvForm.setLocationRelativeTo(null);
					dvForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
		});
		btnDichVu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDichVu.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDichVu.setForeground(customColor);
			}
		});
		btnDichVu.setHorizontalAlignment(SwingConstants.LEFT);
		btnDichVu.setIcon(new ImageIcon(MenuForm.class.getResource("/QLKS_IMAGE/DichVu.png")));
		btnDichVu.setForeground(new Color(25, 25, 112));
		btnDichVu.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDichVu.setBackground(new Color(173, 216, 230));
		btnDichVu.setBounds(364, 162, 239, 63);
		panel_1.add(btnDichVu);
		
		JButton btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.addActionListener(new ActionListener() {
			HoaDonForm hdForm = new HoaDonForm();
			public void actionPerformed(ActionEvent arg0) {
				if(!hdForm.isActive())
				{
					hdForm.setVisible(true);
					hdForm.setLocationRelativeTo(null);
					hdForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}
		});
		btnHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHoaDon.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHoaDon.setForeground(customColor);
			}
		});
		btnHoaDon.setIcon(new ImageIcon(MenuForm.class.getResource("/QLKS_IMAGE/HoaDon.png")));
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setForeground(new Color(25, 25, 112));
		btnHoaDon.setFont(new Font("Arial", Font.PLAIN, 17));
		btnHoaDon.setBackground(new Color(173, 216, 230));
		btnHoaDon.setBounds(67, 272, 239, 63);
		panel_1.add(btnHoaDon);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuForm.this.dispose();
				LoginForm lgForm = new LoginForm();
				lgForm.setVisible(true);
				lgForm.setLocationRelativeTo(null);
				lgForm.setDefaultCloseOperation(EXIT_ON_CLOSE);
			}
		});
		btnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDangXuat.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDangXuat.setForeground(customColor);
			}
		});
		btnDangXuat.setIcon(new ImageIcon(MenuForm.class.getResource("/QLKS_IMAGE/DangXuat.png")));
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setForeground(new Color(25, 25, 112));
		btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuat.setBackground(new Color(173, 216, 230));
		btnDangXuat.setBounds(364, 272, 239, 63);
		panel_1.add(btnDangXuat);
	}

}
