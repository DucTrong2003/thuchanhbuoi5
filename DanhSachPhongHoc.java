package tuan4_M4_PhongHoc_KhongInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachPhongHoc {
	List<PhongHoc> dsPhongHoc = null;
	public DanhSachPhongHoc() {
		dsPhongHoc = new ArrayList<PhongHoc>();
	}
	
	/**
	 * Cập nhật số máy tính
	 * @param phongHoc
	 * @param soLuongCapNhat
	 * @return
	 */
	public boolean capNhatSoMayTinh(String maPhongHoc,int soLuongCapNhat) {
		PhongHocMayTinh phongCapNhat = new PhongHocMayTinh();
		PhongHoc phongTim = this.timPhongHoc(maPhongHoc);
		if(phongTim != null && phongTim instanceof PhongHocMayTinh) {
			phongCapNhat = (PhongHocMayTinh) phongTim;
			phongCapNhat.setSoLuongMayTinh(soLuongCapNhat);
			dsPhongHoc.set(dsPhongHoc.indexOf(phongCapNhat), phongCapNhat);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Danh sách phòng có 60 máy
	 * @return list object
	 */
	public List<PhongHoc> danhSachPhongMayCo60May() {
		List<PhongHoc> dsTam = new ArrayList<PhongHoc>();
		for(PhongHoc phongHoc: dsPhongHoc) {
//			System.out.println("kk");
			if(phongHoc instanceof PhongHocMayTinh && (((PhongHocMayTinh) phongHoc).getSoLuongMayTinh() == (int)60)) {
				dsTam.add(phongHoc);
			}
		}
		return dsTam;
	}
	
	/**
	 * Thêm mới phòng học
	 * @param phongHoc
	 */
	
	public boolean themMotPhongHoc(PhongHoc phongHoc) {
		if(dsPhongHoc.contains(phongHoc)) {
			return false;
		}else {
			dsPhongHoc.add(phongHoc);
			return true;
		}	
	}
	
	/**
	 * Xóa phòng học
	 * @param maPhongHoc
	 * @return boolean
	 */
	
	public boolean xoaPhongHoc(String maPhongHoc) {
		PhongHoc phongTim = this.timPhongHoc(maPhongHoc);
		if(phongTim != null) {
			dsPhongHoc.remove(phongTim);
		}
		return false;
	}
	
	/**
	 * Tìm phòng học obj
	 * @param maPhongHoc
	 * @return object
	 */
	
	public PhongHoc timPhongHoc(String maPhongHoc) {
		for(PhongHoc phongHoc : dsPhongHoc) {
			if(phongHoc.getMaPhong().equalsIgnoreCase(maPhongHoc)) {
				return phongHoc;
			}
		}
		return null;
	}
	
	public void sapXepTangDanTheoDayNha() {
		Collections.sort(dsPhongHoc, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				
				return o1.getDayNha().compareTo(o2.getDayNha());
			}
		});
		
	}
	
	public void sapXepGiamDanTheoDienTich() {
		Collections.sort(dsPhongHoc, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Double obj1 =  o1.getDienTich();
				Double obj2 =  o2.getDienTich();
		
				return obj2.compareTo(obj1);
			}
		});
		
	}
	
	public void sapXepTangDanTheoSoBongDen() {
		Collections.sort(dsPhongHoc, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Integer obj1 =  o1.getSoBongDen();
				Integer obj2 =  o2.getSoBongDen();
		
				return obj1.compareTo(obj2);
			}
		});
		
	}
	
	/**
	 * Tổng Số Phòng Học
	 * return count of list
	 */
	
	public int tongSoPhongHoc() {
		return dsPhongHoc.size();
	}
	
	
	public List<PhongHoc> danhSachPhongDatChuan() {
		List<PhongHoc> dsTam = new ArrayList<PhongHoc>();
		for(PhongHoc phongHoc : dsPhongHoc) {
			if(phongHoc.isDatChuan()) {
				dsTam.add(phongHoc);
			}
		}
		return dsTam;
	}
	
	public List<PhongHoc> layHetDanhSach() {
		return dsPhongHoc;
	}
	
	public void sapXepTheoID() {
		Collections.sort(dsPhongHoc, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				
				return o1.getMaPhong().compareTo(o2.getMaPhong());
			}
		});
		
	}
	
}
