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

public class NhanVienForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaNhanVien;
	private JTextField txtTenNhanVien;
	private JTextField txtChucVu;
	private JTextField txtLuong;
	private JTextField txtNgaySinh;
	private JTextField txtGioiTinh;
	private JTextField txtChuThich;
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
					NhanVienForm frame = new NhanVienForm();
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
	 
		public void hienThiDanhSachNhanVien()
		{
	        try
			{
				String sql ="select * from nhanvien";
				st = con.createStatement();
				ResultSet result = st.executeQuery(sql);
				model = new DefaultTableModel();
				model.addColumn("Mã nhân viên");
				model.addColumn("Tên nhân viên");
				model.addColumn("Chức vụ");
				model.addColumn("Lương nhân viên");
				model.addColumn("Ngày sinh");
				model.addColumn("Giới tính");
				model.addColumn("Chú thích");
				while (result.next())
				{
					Vector<Object> vec = new Vector<Object>();
					vec.add(result.getString(1));
					vec.add(result.getString(2));
					vec.add(result.getString(3));
					vec.add(result.getDouble(4));
					vec.add(result.getDate(5));
					vec.add(result.getString(6));
					vec.add(result.getString(7));
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
	public NhanVienForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NhanVienForm.class.getResource("/QLKS_IMAGE/hotel.png")));
		setTitle("Quản lý khách sạn");
		ketNoiCSDLMySql();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1112, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setForeground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH NHÂN VIÊN");
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
		panel_2.setBounds(10, 23, 442, 502);
		panel_1.add(panel_2);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(173, 20, 169, 24);
		panel_2.add(txtMaNhanVien);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 20, 175, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 73, 175, 24);
		panel_2.add(lblNewLabel_1_1);
		
		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenNhanVien.setColumns(10);
		txtTenNhanVien.setBounds(173, 73, 169, 24);
		panel_2.add(txtTenNhanVien);
		
		JLabel lblNewLabel_1_2 = new JLabel("Chức vụ");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 127, 175, 24);
		panel_2.add(lblNewLabel_1_2);
		
		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Arial", Font.PLAIN, 17));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(173, 127, 169, 24);
		panel_2.add(txtChucVu);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "INSERT INTO NhanVien(MANV,TENNV,CHUCVU, LUONGNV, NGAYSINH, GIOITINH, CHUTHICH) VALUES('" + txtMaNhanVien.getText() + "',"
		                    + "'" + txtTenNhanVien.getText() + "','" + txtChucVu.getText() + "','" + txtLuong.getText() + "','" + txtNgaySinh.getText() + "','" + txtGioiTinh.getText() + "','" + txtChuThich.getText() + "')";

		            st.execute(query);
		            hienThiDanhSachNhanVien();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThem.setBackground(new Color(30, 144, 255));
		btnThem.setBounds(10, 377, 111, 33);
		panel_2.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (table.getSelectedRow()==-1) {
		            if (table.getRowCount()==0) {
		                // lblError.setText("Table is empty");
		            }
		            else{
		                //  lblError.setText("You must select a Tennis Player");
		            }
		        }
		        else{
		            model = (DefaultTableModel) table.getModel();
		            
		            try {
		            	String code = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
			            // Tạo một đối tượng để thực hiện công việc
			            st = (Statement) con.createStatement();
			            String query = "DELETE FROM nhanvien WHERE MANV = '" + code + "'";
			            st.executeUpdate(query);

			        } catch (Exception ex) {

			            ex.printStackTrace();
			        }
		            
		            try {
			            // Tạo một đối tượng để thực hiện công việc
			            st = (Statement) con.createStatement();
			            String query = "INSERT INTO NhanVien(MANV,TENNV,CHUCVU, LUONGNV, NGAYSINH, GIOITINH, CHUTHICH) VALUES('" + txtMaNhanVien.getText() + "',"
			                    + "'" + txtTenNhanVien.getText() + "','" + txtChucVu.getText() + "','" + txtLuong.getText() + "','" + txtNgaySinh.getText() + "','" + txtGioiTinh.getText() + "','" + txtChuThich.getText() + "')";

			            st.execute(query);
			            hienThiDanhSachNhanVien();

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
		            table.setModel(model);
		        }
			}
		});
		btnSua.setForeground(Color.WHITE);
		btnSua.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSua.setBackground(new Color(30, 144, 255));
		btnSua.setBounds(143, 377, 111, 33);
		panel_2.add(btnSua);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMaNhanVien.setText("");
				txtTenNhanVien.setText("");
				txtChucVu.setText("");
				txtGioiTinh.setText("");
				txtLuong.setText("");
				txtChuThich.setText("");
				txtNgaySinh.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 17));
		btnClear.setBackground(new Color(30, 144, 255));
		btnClear.setBounds(279, 377, 111, 33);
		panel_2.add(btnClear);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "DELETE FROM nhanvien WHERE MANV = '" + txtMaNhanVien.getText() + "'";
		            st.executeUpdate(query);
		            hienThiDanhSachNhanVien();

		        } catch (Exception ex) {

		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXoa.setBackground(new Color(30, 144, 255));
		btnXoa.setBounds(10, 438, 111, 33);
		panel_2.add(btnXoa);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NhanVienForm.this.dispose();
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThoat.setBackground(new Color(30, 144, 255));
		btnThoat.setBounds(143, 438, 111, 33);
		panel_2.add(btnThoat);
		
		txtLuong = new JTextField();
		txtLuong.setFont(new Font("Arial", Font.PLAIN, 17));
		txtLuong.setColumns(10);
		txtLuong.setBounds(173, 178, 169, 24);
		panel_2.add(txtLuong);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Lương");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 178, 175, 24);
		panel_2.add(lblNewLabel_1_2_1);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(173, 227, 169, 24);
		panel_2.add(txtNgaySinh);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Ngày sinh");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(10, 227, 175, 24);
		panel_2.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Giới tính");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1.setBounds(10, 277, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1);
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(173, 277, 169, 24);
		panel_2.add(txtGioiTinh);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Chú thích");
		lblNewLabel_1_2_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1_1.setBounds(10, 328, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1_1);
		
		txtChuThich = new JTextField();
		txtChuThich.setFont(new Font("Arial", Font.PLAIN, 17));
		txtChuThich.setColumns(10);
		txtChuThich.setBounds(173, 328, 169, 24);
		panel_2.add(txtChuThich);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin nhân viên");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 10, 138, 13);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(480, 23, 597, 502);
		panel_1.add(panel_2_1);
		
		//panel_2_1.add(scrollPane);
		
		panel_2_1.setLayout(new BorderLayout(0, 0));
		hienThiDanhSachNhanVien();
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		JScrollPane scTable = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel_2_1.add(scTable, BorderLayout.CENTER);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
	}

}
