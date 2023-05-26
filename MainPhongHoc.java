
package thuchanhbuoi5;

import java.util.Scanner;

public class testPhongHoc {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			DanhSachPhongHoc dsPhongHoc = new DanhSachPhongHoc();
			System.out.println("\t\t\tchương trình quản lý phòng học".toUpperCase());
			menuPhongHoc(dsPhongHoc);
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Lỗi chương trình ! Chương trình dừng lại".toUpperCase());
		}

	}
	private static void tieuDe() {
		System.out.println(String.format("%15s | %-20s | %15s | %15s | %15s | %15s | %-25s | %15s | %-15s | %-20s", "Mã Phòng","Dãy Nhà","Diện Tích","Số Bóng Đèn","Máy Chiếu","Số Máy Tính","Thông Tin Chuyên Ngành","Sức Chứa","Bồn Rửa","Loại Phòng"));
	}
	private static void tieuDeMenu() {
		System.out.println("=======================================================");
		System.out.println("\t\tquan ly phong hoc".toUpperCase());
		System.out.println("=======================================================");
		System.out.println("0. Nhap kiem tra du lieu Phong Hoc.");
		System.out.println("1. Nhap them Phong Hoc.");
		System.out.println("2. Tim kiem Phong Hoc.");
		System.out.println("3. In danh sach Phong Hoc.");
		System.out.println("4. In danh sach Phong Hoc dat chuan.");
		System.out.println("5. Sap xep danh sach tang dan theo cot day nha.");
		System.out.println("6. Sap xep danh sach giam dan theo cot dien tich.");
		System.out.println("7. Sap xep danh sach tang dan theo cot so bong đen.");
		System.out.println("8. Cap nhat so may tinh cho mot phong may tinh.");
		System.out.println("9. Xoa mot Phong Hoc.");
		System.out.println("10. In ra tong so phong hoc.");
		System.out.println("11. In danh sach cac phong may co 60 may.");
		System.out.println("12. Thoat.");
	}
	private static void menuPhongHoc(DanhSachPhongHoc dsPhongHoc) {
		
		int chon = 0;
		do {
			tieuDeMenu();
			System.out.println("Ban chon ?: ");
			try {
				chon = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Ban vua nhap sai !");
				throw null;
			}

			if(chon < 0 || chon > 12) {
				System.out.println("Chon sai! Chon tu (0 đen 12)!\nChon lai: ");
			}else {
				switch (chon) {
				case 1://1. Nhập mềm Phòng Học.
					menuChonNhapMem(dsPhongHoc);
					break;
				case 2://2. Tìm kiếm Phòng Học.
					timPhongHoc(dsPhongHoc);
					break;
				case 3://3. In danh sách Phòng Học.
					dsPhongHoc.sapXepTheoID();
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 4://4. In danh sách Phòng Học đạt chuẩn.
					xuatDanhSachPhongDatChuan(dsPhongHoc);
					break;
				case 5://5. Sắp xếp danh sách tăng dần theo cột dãy nhà.
					dsPhongHoc.sapXepTangDanTheoDayNha();
					System.out.println("\t\t\t\tdanh sách sắp xếp tăng dần theo dãy nhà".toUpperCase());
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 6://6. Sắp xếp danh sách giảm dần theo cột diện tích.
					dsPhongHoc.sapXepGiamDanTheoDienTich();
					System.out.println("\t\t\t\tdanh sách sắp xếp giảm dần theo diện tích".toUpperCase());
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 7://7. Sắp xếp danh sách tăng dần theo cột số bóng đèn.
					dsPhongHoc.sapXepTangDanTheoSoBongDen();
					System.out.println("\t\t\t\tdanh sách sắp tăng dần theo số bóng đèn".toUpperCase());
					xuatDanhSachPhong(dsPhongHoc);
					break;
				case 8://8. Cập nhật số máy tính cho một phòng máy tính.
					capNhatMayTinh(dsPhongHoc);
					break;
				case 9://9. Xóa một Phòng Học.
					xoaMotPhongHoc(dsPhongHoc);
					break;
				case 10://10. In ra tổng số phòng học.
					inTongSoPhongHoc(dsPhongHoc);
					break;
				case 11://11. In danh sách các phòng máy có 60 máy.
					inDanhSachPhongMay60(dsPhongHoc);
					break;
					
				case 0://Nhập cứng
					nhapCungPhongHoc(dsPhongHoc);
					break;
				default:
					
					break;
				}
			}

		}while(chon != 12);
	}

	private static void nhapCungPhongHoc(DanhSachPhongHoc dsPhongHoc) {
		PhongHoc phong1 = new PhongLyThuyet("MB1", "A01", 200, 20, true);//phòng chuẩn
		PhongHoc phong2 = new PhongLyThuyet("MB2", "A02", 150, 20, false);

		PhongHoc phong3 = new PhongHocMayTinh("MB3", "B01", 500, 55, 334);//phòng chuẩn
		PhongHoc phong4 = new PhongHocMayTinh("MB4", "B02", 500, 40, 200);

		PhongHoc phong5 = new PhongThiNghiem("MB5", "C01", 400, 44, "Hoa hoc", 80, true);//phòng chuẩn
		PhongHoc phong6 = new PhongThiNghiem("MB6", "D01", 400, 44, "Vat ly", 30, false);
		if(dsPhongHoc.themMotPhongHoc(phong1)) {
			System.out.println("Them thanh cong: "+phong1.getMaPhong());
		}else {
			System.out.println("Them that bai: "+phong1.getMaPhong()+" -Đã tồn tại!!" );
		}

		if(dsPhongHoc.themMotPhongHoc(phong2)) {
			System.out.println("Them thanh cong: "+phong2.getMaPhong());
		}else {
			System.out.println("Them that bai: "+phong2.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong3)) {
			System.out.println("Them thanh cong: "+phong3.getMaPhong());
		}else {
			System.out.println("Them that bai: "+phong3.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong4)) {
			System.out.println("Them thanh cong: "+phong4.getMaPhong());
		}else {
			System.out.println("Them that bai: "+phong4.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong5)) {
			System.out.println("Them thanh cong: "+phong5.getMaPhong());
		}else {
			System.out.println("Them that bai: "+phong5.getMaPhong()+" -Đã tồn tại!!" );
		}
		if(dsPhongHoc.themMotPhongHoc(phong6)) {
			System.out.println("Them thanh cong: "+phong6.getMaPhong());
		}else {
			System.out.println("Them that bai: "+phong6.getMaPhong()+" -Đã tồn tại!!" );
		}
		System.out.println("\n");
	}

	private static void menuChonNhapMem(DanhSachPhongHoc dsPhongHoc) {
		
		int chon = 0;
		do {
			System.out.println("=======================================");
			System.out.println("\t\t\t menu chon nhap them ".toUpperCase());
			System.out.println("=======================================");
			System.out.println("1. NHAP PHONG LY THUYET.");
			System.out.println("2. NHAP PHONG MAY TINH.");
			System.out.println("3. NHAP PHONG THI NGHIEM .");
			System.out.println("Ban chon ?: ");
			chon = sc.nextInt();
			if(chon < 0 || chon > 3) {
				System.out.println("Chon sai! chon lai!");
				System.out.println("1. NHAP PHONG LY THUYET.");
				System.out.println("2. NHAP PHONG MAY TINH.");
				System.out.println("3. NHAP PHONG THI NGHIEM.");
				System.out.println("Ban chon nhap?: ");
			}else {
				switch (chon) {
				case 1:
					int phongLyThuyet = 1;
					nhapMemPhongHoc(dsPhongHoc, phongLyThuyet);
					chon = 412;
					break;
				case 2:
					int phongMayTinh = 2;
					nhapMemPhongHoc(dsPhongHoc, phongMayTinh);
					chon = 412;
					break;
				case 3:
					int phongThiNghiem = 3;
					nhapMemPhongHoc(dsPhongHoc, phongThiNghiem);
					chon = 412;
					break;
				default:
					break;
				}
			}
		}while(chon != 412);
	}
	/**
	 * case 1: Nhập mềm phòng học
	 * @param dsPhongHoc
	 * @param loaiPhong
	 */
	private static void nhapMemPhongHoc(DanhSachPhongHoc dsPhongHoc,int loaiPhong) {
		int phongLyThuyet = 1, phongMayTinh = 2,phongThiNghiem = 3;
		sc.nextLine();
		System.out.println("Nhap ma phong hoc: ");
		String checkMa = null;
		String maPhongHoc = nhapChuoi(checkMa, "ma phong hoc");

		System.out.println("Nhap day nha: ");
		String checkDayNha = null;
		String dayNha = nhapChuoi(checkDayNha, "day nha");

		System.out.println("Nhap dien tich: ");
		long checkDientich = 0;
		double dienTich = (double) nhapSo(checkDientich, "dien tich");

		System.out.println("Nhap so bong đen: ");
		long checkSoBongDen = 0;
		int bongDen = (int) nhapSo(checkSoBongDen, "so bong đen");

		if(loaiPhong == phongLyThuyet) {
			System.out.println("Co may chieu(1: yes, 2: no ): ");
			int kiemTraMayChieu = 0;
			do {
				try {
					kiemTraMayChieu = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Ban vua nhap kiem tra co may chieu khong phai so!");
					throw null;
				}

				if(kiemTraMayChieu > 2 || kiemTraMayChieu < 1) {
					System.out.println("Nhap sai!");
					System.out.println("Co may chieu(1: yes, 2: no): ");
				}else {
					boolean coMayChieu = (kiemTraMayChieu == 1)?true:false;
					PhongLyThuyet phongMoi = new PhongLyThuyet(maPhongHoc, dayNha, dienTich, bongDen, coMayChieu);
					dsPhongHoc.themMotPhongHoc(phongMoi);
				}
			}while(kiemTraMayChieu > 2 || kiemTraMayChieu < 1);

		}else if (loaiPhong == phongMayTinh) {
			System.out.println("Nhap  so may tinh: ");
			long checkSoLuong = 0;
			int soLuongMayTinh = (int) nhapSo(checkSoLuong, "So luong may tinh");
			PhongHocMayTinh phongMoi = new PhongHocMayTinh(maPhongHoc, dayNha, dienTich, bongDen, soLuongMayTinh);
			dsPhongHoc.themMotPhongHoc(phongMoi);
		}else if (loaiPhong == phongThiNghiem) {
			sc.nextLine();
			System.out.println("Nhap thong tin Chuyen Nganh: ");
			String checkThongTinChuyenNganh = null;
			String thongTinChuyenNganh = nhapChuoi(checkThongTinChuyenNganh, "thông tin chuyên ngành");

			System.out.println("Nhap suc chua: ");
			long checkSucChua = 0;
			int sucChua = (int) nhapSo(checkSucChua, "Suc chua");

			System.out.println("Co bon rua(1: Co, 2: Khong): ");
			int kiemTraBonRua = 0;
			do {
				try {
					kiemTraBonRua = sc.nextInt();
				} catch (Exception e) {
					System.out.println("Bạn vừa nhập kiểm tra có bồn rửa không phải số!");
					throw null;
				}

				if(kiemTraBonRua > 2 || kiemTraBonRua < 1) {
					System.out.println("Nhap sai!");
					System.out.println("Co bon rua(1: Co, 2: Khong): ");
				}else {
					boolean coBonRua = (kiemTraBonRua == 1)?true:false;
					PhongThiNghiem phongMoi = new PhongThiNghiem(maPhongHoc, dayNha, dienTich, bongDen, thongTinChuyenNganh, sucChua, coBonRua);
					dsPhongHoc.themMotPhongHoc(phongMoi);
				}
			}while(kiemTraBonRua > 2 || kiemTraBonRua < 1);

		}

	}

	/**
	 * case 2 Tìm phòng học
	 */
	private static void timPhongHoc(DanhSachPhongHoc dsPhongHoc) {
		sc.nextLine();
		System.out.println("Nhap ma phong can tim: ");
		String maCheck = null;
		String maCheckCanTim = nhapChuoi(maCheck, "Ma can tim");
		PhongHoc objTim = dsPhongHoc.timPhongHoc(maCheckCanTim);
		if(objTim !=null) {
			System.out.println("Tim thay phong: "+maCheckCanTim);
			tieuDe();
			System.out.println(objTim);
		}else {
			System.out.println("Khong tim thay phong: "+maCheckCanTim);
		}

		System.out.println("\n");
	}

	/**
	 * case 3 In danh sách phòng
	 * @param dsPhongHoc
	 */
	private static void xuatDanhSachPhong(DanhSachPhongHoc dsPhongHoc) {
		if(!dsPhongHoc.layHetDanhSach().isEmpty()) {
			System.out.println("\t\t\t\tdanh sach phong hoc".toUpperCase());
			tieuDe();
			for(PhongHoc phong: dsPhongHoc.layHetDanhSach()) {
				System.out.println(phong);
			}
		}else {
			System.out.println("Danh sach rong");
		}

		System.out.println("\n");
	}

	/**
	 * case 4 in danh sách phòng đạt chuẩn
	 * @param dsPhongHoc
	 */
	private static void xuatDanhSachPhongDatChuan(DanhSachPhongHoc dsPhongHoc) {
		System.out.println("\t\t\t\tdanh sach phong hoc chuan".toUpperCase());
		tieuDe();
		for(PhongHoc phong: dsPhongHoc.danhSachPhongDatChuan()) {
			System.out.println(phong);
		}
		System.out.println("\n");
	}

	/**
	 * case 8 Cập nhật số máy tính cho một phòng máy tính
	 * @param dsPhongHoc
	 */
	private static void capNhatMayTinh(DanhSachPhongHoc dsPhongHoc) {
		sc.nextLine();
		System.out.println("Nhập mã phòng máy tính cần cập nhật");
		String checkMaPhongHoc = null;
		String maPhongHoc = nhapChuoi(checkMaPhongHoc, "mã phòng học");
		PhongHoc phongTim = dsPhongHoc.timPhongHoc(maPhongHoc);
		if(phongTim != null) {
			System.out.println("Cập nhật lại số lượng máy tính: ");
			long checkSoLuongMay = 0;
			int soLuongMayTinh = (int) nhapSo(checkSoLuongMay, "số lượng máy tính");
			if(dsPhongHoc.capNhatSoMayTinh(maPhongHoc, soLuongMayTinh)) {
				System.out.println("Cập nhật thành công!");
			}else {
				System.out.println("Mã phòng: "+maPhongHoc+" - Không phải là phòng máy tính");
			}
		}else {
			System.out.println("Mã phòng: "+maPhongHoc+" - Không tồn tại");
		}
		System.out.println("\n");
	}

	/**
	 * case 9 Xóa một Phòng Học
	 */
	private static void xoaMotPhongHoc(DanhSachPhongHoc dsPhongHoc) {
		sc.nextLine();
		System.out.println("Nhập mã cần xóa");
		String checkMaPhongHoc = null;
		String maPhongHoc = nhapChuoi(checkMaPhongHoc, "mã phòng học");
		PhongHoc phongTim = dsPhongHoc.timPhongHoc(maPhongHoc);
		if(phongTim != null) {
			if(dsPhongHoc.xoaPhongHoc(maPhongHoc)) {
				System.out.println("Xóa thành công "+maPhongHoc);
			}else {
				System.out.println("Xóa không thành công "+maPhongHoc);
			}

		}else {
			System.out.println("Mã phòng: "+maPhongHoc+" - Không tồn tại");
		}
		System.out.println("\n");

	}

	/**
	 * case 10 In ra tổng số phòng học
	 * @param dsPhongHoc
	 */
	private static void inTongSoPhongHoc(DanhSachPhongHoc dsPhongHoc) {
		System.out.println("Tổng số phòng học là: "+ dsPhongHoc.tongSoPhongHoc());
		System.out.println("\n");
	}

	/**
	 * case 11 In danh sách các phòng máy có 60 máy
	 * @param dsPhongHoc
	 */
	private static void inDanhSachPhongMay60(DanhSachPhongHoc dsPhongHoc) {

		if(!dsPhongHoc.danhSachPhongMayCo60May().isEmpty()) {
			System.out.println("\t\t\t\tdanh sách phòng máy tình có 60 máy".toUpperCase());
			tieuDe();
			for(PhongHoc phong : dsPhongHoc.danhSachPhongMayCo60May()) {
				System.out.println(phong);
			}
		}else {
			System.out.println("Danh sách rỗng");
		}

		System.out.println("\n");
	}

	//input
	public static long nhapSo(long number, String text) {
		String title = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();//in hoa chữ cái đầu
		do {
			try {
				number = sc.nextLong();
			} catch (Exception e) {
				System.out.println(title+ "bạn vừa nhập không phải số");
				throw null;
			}
			if(number < 0) {
				System.out.println(title+" - Không được bé hơn 0!\nNhập lại:");
			}
		}while(number < 0);
		return number;
	}

	public static String nhapChuoi(String str, String text) {
		String title = text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();//in hoa chữ cái đầu
		do {
			try {
				str = sc.nextLine();
			} catch (Exception e) {
				System.out.println("Something wrong!!");
				throw null;
			}
			if(str == null || str.isEmpty()) {
				System.out.println(title+" - Không được để trống!\nNhập lại:");
			}
		}while(str == null || str.isEmpty());
		return str;
	}
	//end input
}
