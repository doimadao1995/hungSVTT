create database VeXeOnline
use VeXeOnline

create table GiaVe
(
	MaGiaVe nvarchar(20) not null primary key,
	GiaVe float not null
)

create table LichTrinh
(
	MaLichTrinh nvarchar(20) not null primary key,
	DiemDi nvarchar(50) not null,
	DiemDen nvarchar(50) not null,
	MaGiaVe nvarchar(20) not null,
	ThoiGianChay nvarchar(10),
	QuangDuong nvarchar(10)
)
alter table LichTrinh add foreign key(MaGiaVe) references GiaVe(MaGiaVe)

create table Xe
(
	MaXe nvarchar(20) not null primary key,
	LoaiXe nvarchar(50) not null,
	SoCho int not null
)

create table LichXe
(
	MaLichXe nvarchar(20) not null primary key,
	MaXe nvarchar(20) not null,
	MaLichTrinh nvarchar(20) not null,
	GioXuatPhat nvarchar(10)
)

alter table LichXe add foreign key(MaXe) references Xe(MaXe)
alter table LichXe add foreign key(MaLichTrinh) references LichTrinh(MaLichTrinh)

create table DuLieuXe
(
	MaDuLieuXe nvarchar(20) not null primary key,
	MaLichXe nvarchar(20) not null,
	NgayDi date,
	SoChoConLai int
)
alter table DuLieuXe add foreign key(MaLichXe) references LichXe(MaLichXe)

create table Account
(
	MaAccount nvarchar(20) not null primary key,
	MatKhau nvarchar(50) not null,
	Quyen int not null,
	HoTen nvarchar(50),
	Email nvarchar(50),
	SoDienThoai nvarchar(11),
	DiaChi nvarchar(200),
	TinhTrang int
)

create table ChiTietVeXe
(
	MaVeXe int not null primary key identity,
	MaLichXe nvarchar(20) not null,
	MaAccount nvarchar(20) not null,
	NgayDatVe date,
	NgayDi date,
	DiemDonKhach nvarchar(100),
	DiemTraKhach nvarchar(100),
	SoLuongVe int,
	TongTien float,
	TinhTrangThanhToan int
)
alter table ChiTietVeXe add foreign key(MaLichXe) references LichXe(MaLichXe)
alter table ChiTietVeXe add foreign key(MaAccount) references Account(MaAccount)


create table DiemDonKhach
(
	ID int not null primary key identity,
	MaLichTrinh nvarchar(20) not null,
	TenDiemDonKhach nvarchar(100) not null	
)
alter table DiemDonKhach add foreign key(MaLichTrinh) references LichTrinh(MaLichTrinh)

create table DiemTraKhach
(
	ID int not null primary key identity,
	MaLichTrinh nvarchar(20) not null,
	TenDiemTraKhach nvarchar(100) not null
)
alter table DiemTraKhach add foreign key(MaLichTrinh) references LichTrinh(MaLichTrinh)

create table TinTuc
(
	IDTinTuc int not null primary key identity,
	TieuDeTin nvarchar(100) not null,
	NoiDungTin text not null,
	NgayDangTin date not null,
	MaNguoiDang nvarchar(20) not null,
	HinhAnh nvarchar(50),
	TinhTrang int
)
alter table TinTuc add foreign key(MaNguoiDang) references Account(MaAccount)


select NgayDi,LichXe.MaLichTrinh,SoChoConLai from DuLieuXe inner join LichXe on DuLieuXe.MaLichXe = LichXe.MaLichXe    DuLieuXe.NgayDi = '2017-03-09'

select distinct NgayDi,SoChoConLai from DuLieuXe inner join LichXe on DuLieuXe.MaLichXe = LichXe.MaLichXe where LichXe.MaLichTrinh = N'QN-DN' and MIN(


select * from Xe inner join LichXe on Xe.MaXe = LichXe.MaXe 
select  from Xe inner join LichXe on Xe.MaXe = LichXe.MaXe where LichXe.MaLichTrinh = N'QN-DN' and LichXe.GioXuatPhat = N'07:00'



select GiaVe from GiaVe inner join LichTrinh on LichTrinh.MaGiaVe = GiaVe.MaGiaVe where LichTrinh.MaLichTrinh = N'QN-DN'






// nhung doan duoi k lien quan


select * from LichTrinh inner join GiaVe on LichTrinh.MaGiaVe = GiaVe.MaGiaVe

use VeXeOnline

select * from LichTrinh 
select MaLichTrinh from LichTrinh where DiemDen=N'Đà Nẵng' and DiemDi=N'Quy Nhơn'

select distinct TenDiemDonKhach, TenDiemTraKhach from DiemDonKhach,DiemTraKhach where DiemDonKhach.MaLichTrinh = DiemTraKhach.MaLichTrinh

select TenDiemDonKhach, TenDiemTraKhach,DiemDonKhach.MaLichTrinh from DiemDonKhach,DiemTraKhach where DiemDonKhach.MaLichTrinh = DiemTraKhach.MaLichTrinh

select TenDiemDonKhach, TenDiemTraKhach from DiemDonKhach,DiemTraKhach where DiemDonKhach.MaLichTrinh = DiemTraKhach.MaLichTrinh and DiemDonKhach.MaLichTrinh = 'QN-DN'

select * from DuLieuXe where MaLichTrinh = 'QN-DN'

select distinct TenDiemDonKhach from DiemDonKhach
select * from DiemDonKhach