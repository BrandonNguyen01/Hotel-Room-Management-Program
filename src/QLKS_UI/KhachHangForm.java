package QLKS_UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Vector;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class KhachHangForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtCCCD;
	private JTextField txtQuocTich;
	private JTextField txtGioiTinh;
	private JTextField txtTuoi;
	private JTextField txtSoDienThoai;
	private JTextField txtMaPhong;
	//private JTable table;

	DefaultTableModel model;
	JTable table; 
	
	public static Connection con= null;
    public static Statement st= null; 
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHangForm frame = new KhachHangForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ketNoiCSDLMySql() {
		// TODO Auto-generated method stub
		try
		{
			String strlConn = "jdbc:mysql://localhost/ql_khachsan";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			con = driver.connect(strlConn, pro);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public void hienThiDanhSachKhachHang()
	{
        try
		{
			String sql ="select * from khachhang";
			st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			model = new DefaultTableModel();
			model.addColumn("Mã khách hàng");
			model.addColumn("Tên khách hàng");
			model.addColumn("Căn cước công dân");
			model.addColumn("Quốc tịch");
			model.addColumn("Giới tính");
			model.addColumn("Tuổi");
			while (result.next())
			{
				Vector<Object> vec = new Vector<Object>();
				vec.add(result.getString(1));
				vec.add(result.getString(2));
				vec.add(result.getString(3));
				vec.add(result.getString(4));
				vec.add(result.getString(5));
				vec.add(result.getInt(6));
				vec.add(result.getString(7));
				vec.add(result.getString(8));
				model.addRow(vec);
			}
		}
		catch (Exception ex)
		{
			
		}
	}
	
	/**
	 * Create the frame.
	 */
	public KhachHangForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(KhachHangForm.class.getResource("/QLKS_IMAGE/hotel.png")));
		ketNoiCSDLMySql();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1208, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 41, 442, 596);
		panel_1.add(panel_2);
		
		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaKhachHang.setColumns(10);
		txtMaKhachHang.setBounds(173, 20, 169, 24);
		panel_2.add(txtMaKhachHang);
		
		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 20, 175, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên khách hàng");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 73, 175, 24);
		panel_2.add(lblNewLabel_1_1);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setBounds(173, 73, 169, 24);
		panel_2.add(txtTenKhachHang);
		
		JLabel lblNewLabel_1_2 = new JLabel("CCCD");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 127, 175, 24);
		panel_2.add(lblNewLabel_1_2);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Arial", Font.PLAIN, 17));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(173, 127, 169, 24);
		panel_2.add(txtCCCD);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "INSERT INTO khachhang(MAKH,TENKH, CMND, QUOCTICH, GIOITINH, TUOI, SDT, MAPHONG) VALUES('" + txtMaKhachHang.getText() + "',"
		                    + "'" + txtTenKhachHang.getText() + "','" + txtCCCD.getText() + "', '" + txtQuocTich.getText() + "', '" + txtGioiTinh.getText() + "', '" + txtTuoi.getText() + "', '" + txtSoDienThoai.getText() + "', '" + txtMaPhong.getText() + "')";

		            st.execute(query);
		            hienThiDanhSachKhachHang();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnThm.setForeground(Color.WHITE);
		btnThm.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThm.setBackground(new Color(30, 144, 255));
		btnThm.setBounds(10, 457, 111, 33);
		panel_2.add(btnThm);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMaKhachHang.setText("");
				txtTenKhachHang.setText("");
				txtCCCD.setText("");
				txtGioiTinh.setText("");
				txtQuocTich.setText("");
				txtSoDienThoai.setText("");
				txtMaPhong.setText("");
				txtTuoi.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 17));
		btnClear.setBackground(new Color(30, 144, 255));
		btnClear.setBounds(231, 457, 111, 33);
		panel_2.add(btnClear);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "DELETE FROM khachhang WHERE MAKH = '" + txtMaKhachHang.getText() + "'";
		            st.executeUpdate(query);
		            hienThiDanhSachKhachHang();

		        } catch (Exception ex) {

		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnXa.setForeground(Color.WHITE);
		btnXa.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXa.setBackground(new Color(30, 144, 255));
		btnXa.setBounds(231, 519, 111, 33);
		panel_2.add(btnXa);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				KhachHangForm.this.dispose();
			}
		});
		btnThot.setForeground(Color.WHITE);
		btnThot.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThot.setBackground(new Color(30, 144, 255));
		btnThot.setBounds(10, 519, 111, 33);
		panel_2.add(btnThot);
		
		txtQuocTich = new JTextField();
		txtQuocTich.setFont(new Font("Arial", Font.PLAIN, 17));
		txtQuocTich.setColumns(10);
		txtQuocTich.setBounds(173, 178, 169, 24);
		panel_2.add(txtQuocTich);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Quốc tịch");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 178, 175, 24);
		panel_2.add(lblNewLabel_1_2_1);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(173, 227, 169, 24);
		panel_2.add(txtGioiTinh);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giới tính");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(10, 227, 175, 24);
		panel_2.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tuổi");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1.setBounds(10, 277, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1);
		
		txtTuoi = new JTextField();
		txtTuoi.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(173, 277, 169, 24);
		panel_2.add(txtTuoi);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_2_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1_1.setBounds(10, 328, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1_1);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Arial", Font.PLAIN, 17));
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(173, 328, 169, 24);
		panel_2.add(txtSoDienThoai);
		
		JLabel lblNewLabel_1_2_2_1_2 = new JLabel("Mã phòng");
		lblNewLabel_1_2_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1_2.setBounds(10, 385, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1_2);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(173, 385, 169, 24);
		panel_2.add(txtMaPhong);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin khách hàng");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 28, 138, 13);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		//panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(486, 41, 688, 596);
		panel_1.add(panel_2_1);
		
		panel_2_1.setLayout(new BorderLayout(0, 0));
		hienThiDanhSachKhachHang();
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JScrollPane scTable = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel_2_1.add(scTable, BorderLayout.CENTER);
		
	}

}
