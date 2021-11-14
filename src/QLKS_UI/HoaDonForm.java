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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Driver;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import QLKS_OBJECT.HoaDon;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import java.awt.Toolkit;


public class HoaDonForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaHoaDon;
	private JTextField txtMaNhanVien;
	private JTextField txtMaPhong;
	private JTextField txtNgay;
	private JTextField txtGiaHoaDon;

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
					HoaDonForm frame = new HoaDonForm();
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
	
	public void hienThiDanhSachHoaDon()
	{
        try
		{
			String sql ="select * from hoadon";
			st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			model = new DefaultTableModel();
			model.addColumn("Mã hóa đơn");
			model.addColumn("Mã nhân viên");
			model.addColumn("Mã phòng");
			model.addColumn("Ngày");
			model.addColumn("Giá hóa đơn");
			while (result.next())
			{
				Vector<Object> vec = new Vector<Object>();
				vec.add(result.getString(1));
				vec.add(result.getString(2));
				vec.add(result.getString(3));
				vec.add(result.getDate(4));
				vec.add(result.getDouble(5));
				model.addRow(vec);
				System.out.println(1);
			}
		}
		catch (Exception ex)
		{
			
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public HoaDonForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HoaDonForm.class.getResource("/QLKS_IMAGE/hotel.png")));
		ketNoiCSDLMySql();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1087, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH HÓA ĐƠN");
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
		panel_2.setBounds(10, 51, 442, 430);
		panel_1.add(panel_2);
		
		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setBounds(155, 20, 169, 24);
		panel_2.add(txtMaHoaDon);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 20, 111, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 73, 131, 24);
		panel_2.add(lblNewLabel_1_1);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(155, 73, 169, 24);
		panel_2.add(txtMaNhanVien);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mã phòng");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 127, 111, 24);
		panel_2.add(lblNewLabel_1_2);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(155, 127, 169, 24);
		panel_2.add(txtMaPhong);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "INSERT INTO hoadon(MAHD,MANV, MAPHONG, NGAY, GIAHD) VALUES('" + txtMaHoaDon.getText() + "',"
		                    + "'" + txtMaNhanVien.getText() + "','" + txtMaPhong.getText() + "', '" + txtNgay.getText() + "', '" + txtGiaHoaDon.getText() + "')";
		            st.execute(query);
		            hienThiDanhSachHoaDon();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBounds(10, 293, 111, 33);
		panel_2.add(btnThem);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMaHoaDon.setText("");
				txtGiaHoaDon.setText("");
				txtMaNhanVien.setText("");
				txtMaPhong.setText("");
				txtNgay.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 17));
		btnClear.setBackground(new Color(30, 144, 255));
		btnClear.setBounds(213, 293, 111, 33);
		panel_2.add(btnClear);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {
			            // Tạo một đối tượng để thực hiện công việc
			            st = (Statement) con.createStatement();
			            String query = "DELETE FROM hoadon WHERE MAHD = '" + txtMaHoaDon.getText() + "'";
			            st.executeUpdate(query);
			            hienThiDanhSachHoaDon();

			        } catch (Exception ex) {

			            ex.printStackTrace();
			        }
			        table.setModel(model);
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBounds(10, 354, 111, 33);
		panel_2.add(btnXoa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HoaDonForm.this.dispose();
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThoat.setBackground(new Color(30, 144, 255));
		btnThoat.setBounds(213, 354, 111, 33);
		panel_2.add(btnThoat);
		
		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNgay.setColumns(10);
		txtNgay.setBounds(155, 178, 169, 24);
		panel_2.add(txtNgay);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 178, 111, 24);
		panel_2.add(lblNewLabel_1_2_1);
		
		txtGiaHoaDon = new JTextField();
		txtGiaHoaDon.setFont(new Font("Arial", Font.PLAIN, 17));
		txtGiaHoaDon.setColumns(10);
		txtGiaHoaDon.setBounds(155, 227, 169, 24);
		panel_2.add(txtGiaHoaDon);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Giá hóa đơn");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(10, 227, 111, 24);
		panel_2.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin hóa đơn");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 38, 138, 13);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(491, 51, 546, 430);
		panel_1.add(panel_2_1);
		
		panel_2_1.setLayout(new BorderLayout(0, 0));
		hienThiDanhSachHoaDon();
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JScrollPane scTable = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel_2_1.add(scTable, BorderLayout.CENTER);
		
		//panel_2_1.add(scrollPane);
		
		
	}

}
