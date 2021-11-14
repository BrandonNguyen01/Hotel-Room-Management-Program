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

public class PhongForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaPhong;
	private JTextField txtTenPhong;
	private JTextField txtLoaiPhong;
	private JTextField txtGiaPhong;
	private JTextField txtChuThich;
	private JTextField txtTinhTrang;
	private JTextField txtMaNhanVien;
	private JTextField txtMaDichVu;
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
					PhongForm frame = new PhongForm();
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
   	
	public void hienThiDanhSachPhong()
	{
        try
		{
			String sql ="select * from phong";
			st = con.createStatement();
			ResultSet result = st.executeQuery(sql);
			model = new DefaultTableModel();
			model.addColumn("Mã phòng");
			model.addColumn("Tên phòng");
			model.addColumn("Loại phòng");
			model.addColumn("Giá Phòng");
			model.addColumn("Chú thích");
			model.addColumn("Tình trạng");
			model.addColumn("Mã nhân viên");
			model.addColumn("Mã dịch vụ");
			while (result.next())
			{
				Vector<Object> vec = new Vector<Object>();
				vec.add(result.getString(1));
				vec.add(result.getString(2));
				vec.add(result.getString(3));
				vec.add(result.getDouble(4));
				vec.add(result.getString(5));
				vec.add(result.getString(6));
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
	public PhongForm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PhongForm.class.getResource("/QLKS_IMAGE/hotel.png")));
		ketNoiCSDLMySql();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1139, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("DANH SÁCH PHÒNG");
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
		panel_2.setBounds(10, 23, 442, 559);
		panel_1.add(panel_2);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaPhong.setColumns(10);
		txtMaPhong.setBounds(173, 20, 169, 24);
		panel_2.add(txtMaPhong);
		
		JLabel lblNewLabel_1 = new JLabel("Mã phòng");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 20, 175, 24);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên phòng");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 73, 175, 24);
		panel_2.add(lblNewLabel_1_1);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(173, 73, 169, 24);
		panel_2.add(txtTenPhong);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại phòng");
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 127, 175, 24);
		panel_2.add(lblNewLabel_1_2);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setFont(new Font("Arial", Font.PLAIN, 17));
		txtLoaiPhong.setColumns(10);
		txtLoaiPhong.setBounds(173, 127, 169, 24);
		panel_2.add(txtLoaiPhong);
		
		JButton btnThm = new JButton("Thêm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "INSERT INTO phong(MAPHONG,TENPHONG, LOAIPHONG, GIAPHONG, CHUTHICH, TINHTRANG, MANV, MADV) VALUES('" + txtMaPhong.getText() + "',"
		                    + "'" + txtTenPhong.getText() + "','" + txtLoaiPhong.getText() + "', '" + txtGiaPhong.getText() + "', '" + txtChuThich.getText() + "', '" + txtTinhTrang.getText() + "', '" + txtMaNhanVien.getText() + "', '" + txtMaDichVu.getText() + "')";

		            st.execute(query);
		            hienThiDanhSachPhong();

		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnThm.setForeground(Color.WHITE);
		btnThm.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThm.setBackground(new Color(30, 144, 255));
		btnThm.setBounds(10, 437, 111, 33);
		panel_2.add(btnThm);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
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
			            String query = "DELETE FROM phong WHERE MAPHONG = '" + code + "'";
			            st.executeUpdate(query);

			        } catch (Exception ex) {

			            ex.printStackTrace();
			        }
		            
		            try {
			            // Tạo một đối tượng để thực hiện công việc
			            st = (Statement) con.createStatement();
			            String query = "INSERT INTO phong(MAPHONG,TENPHONG, LOAIPHONG, GIAPHONG, CHUTHICH, TINHTRANG, MANV, MADV) VALUES('" + txtMaPhong.getText() + "',"
			                    + "'" + txtTenPhong.getText() + "','" + txtLoaiPhong.getText() + "', '" + txtGiaPhong.getText() + "', '" + txtChuThich.getText() + "', '" + txtTinhTrang.getText() + "', '" + txtMaNhanVien.getText() + "', '" + txtMaDichVu.getText() + "')";

			            st.execute(query);
			            hienThiDanhSachPhong();

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
		            table.setModel(model);
		        }
			}
		});
		btnSa.setForeground(Color.WHITE);
		btnSa.setFont(new Font("Arial", Font.PLAIN, 17));
		btnSa.setBackground(new Color(30, 144, 255));
		btnSa.setBounds(143, 437, 111, 33);
		panel_2.add(btnSa);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMaPhong.setText("");
				txtTenPhong.setText("");
				txtLoaiPhong.setText("");
				txtGiaPhong.setText("");
				txtTinhTrang.setText("");
				txtChuThich.setText("");
				txtMaNhanVien.setText("");
				txtMaDichVu.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Arial", Font.PLAIN, 17));
		btnClear.setBackground(new Color(30, 144, 255));
		btnClear.setBounds(279, 437, 111, 33);
		panel_2.add(btnClear);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            // Tạo một đối tượng để thực hiện công việc
		            st = (Statement) con.createStatement();
		            String query = "DELETE FROM phong WHERE MAPHONG = '" + txtMaPhong.getText() + "'";
		            st.executeUpdate(query);
		            hienThiDanhSachPhong();

		        } catch (Exception ex) {

		            ex.printStackTrace();
		        }
		        table.setModel(model);
			}
		});
		btnXa.setForeground(Color.WHITE);
		btnXa.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXa.setBackground(new Color(30, 144, 255));
		btnXa.setBounds(10, 498, 111, 33);
		panel_2.add(btnXa);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PhongForm.this.dispose();
			}
		});
		btnThot.setForeground(Color.WHITE);
		btnThot.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThot.setBackground(new Color(30, 144, 255));
		btnThot.setBounds(143, 498, 111, 33);
		panel_2.add(btnThot);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Arial", Font.PLAIN, 17));
		txtGiaPhong.setColumns(10);
		txtGiaPhong.setBounds(173, 178, 169, 24);
		panel_2.add(txtGiaPhong);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Giá phòng");
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 178, 175, 24);
		panel_2.add(lblNewLabel_1_2_1);
		
		txtChuThich = new JTextField();
		txtChuThich.setFont(new Font("Arial", Font.PLAIN, 17));
		txtChuThich.setColumns(10);
		txtChuThich.setBounds(173, 227, 169, 24);
		panel_2.add(txtChuThich);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Chú thích");
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2.setBounds(10, 227, 175, 24);
		panel_2.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tình trạng");
		lblNewLabel_1_2_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1.setBounds(10, 277, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTinhTrang.setColumns(10);
		txtTinhTrang.setBounds(173, 277, 169, 24);
		panel_2.add(txtTinhTrang);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("Mã nhân viên");
		lblNewLabel_1_2_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1_1.setBounds(10, 328, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1_1);
		
		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBounds(173, 328, 169, 24);
		panel_2.add(txtMaNhanVien);
		
		JLabel lblNewLabel_1_2_2_1_1_1 = new JLabel("Mã dịch vụ");
		lblNewLabel_1_2_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_2_2_1_1_1.setBounds(10, 380, 175, 24);
		panel_2.add(lblNewLabel_1_2_2_1_1_1);
		
		txtMaDichVu = new JTextField();
		txtMaDichVu.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaDichVu.setColumns(10);
		txtMaDichVu.setBounds(173, 380, 169, 24);
		panel_2.add(txtMaDichVu);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin phòng");
		lblNewLabel_2.setForeground(new Color(30, 144, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 10, 138, 13);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(479, 23, 603, 437);
		panel_1.add(panel_2_1);
		
		panel_2_1.setLayout(new BorderLayout(0, 0));
		hienThiDanhSachPhong();
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JScrollPane scTable = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		panel_2_1.add(scTable, BorderLayout.CENTER);
		table.setFont(new Font("Arial", Font.PLAIN, 15));
	}

}
