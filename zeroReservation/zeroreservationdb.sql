-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2017 at 11:13 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zeroreservationdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `bandara`
--

CREATE TABLE `bandara` (
  `id_bandara` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `latitude` varchar(50) NOT NULL,
  `longitude` varchar(50) NOT NULL,
  `kota` varchar(50) NOT NULL,
  `negara` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bandara`
--

INSERT INTO `bandara` (`id_bandara`, `nama`, `latitude`, `longitude`, `kota`, `negara`) VALUES
('CGK', 'SOEKARNO-HATTA', '-6.9037919', '107.5075335', 'JAKARTA', 'INDONESIA');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `no_ktp` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `umur` int(11) NOT NULL,
  `jenis_kelamin` varchar(1) NOT NULL,
  `no_telepon` varchar(15) NOT NULL,
  `saldo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`no_ktp`, `username`, `password`, `nama`, `alamat`, `umur`, `jenis_kelamin`, `no_telepon`, `saldo`) VALUES
('12345', 'tio', 'tio', 'Tio', 'Bandung', 20, 'L', '081233', 0),
('1301154428', 'satrya', 'satrya', 'Satrya', 'Bandung', 20, 'L', '0822777123123', 0),
('23', 'ad', 'asd', 'asd', 'asd', 44, 'L', '123', 0),
('asd', 'asdas', 'asd', 'asd', 'sd', 1, 'L', '23', 0);

-- --------------------------------------------------------

--
-- Table structure for table `detilpesan`
--

CREATE TABLE `detilpesan` (
  `id_detilpesan` int(11) NOT NULL,
  `id_pesan` int(11) NOT NULL,
  `id_penerbangan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE `jadwal` (
  `id_jadwal` int(11) NOT NULL,
  `waktu_brkt` varchar(11) NOT NULL,
  `waktu_tiba` varchar(5) NOT NULL,
  `tgl_penerbangan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--

INSERT INTO `jadwal` (`id_jadwal`, `waktu_brkt`, `waktu_tiba`, `tgl_penerbangan`) VALUES
(1, '', '20:00', '2017-05-09');

-- --------------------------------------------------------

--
-- Table structure for table `maskapai`
--

CREATE TABLE `maskapai` (
  `id_maskapai` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jmlh_pesawat` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maskapai`
--

INSERT INTO `maskapai` (`id_maskapai`, `username`, `password`, `nama`, `jmlh_pesawat`) VALUES
('GA', 'GA', '1234', 'Garuda Indonesia', 240),
('LA', 'LA', '1234', 'Lion Air', 123);

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id_bayar` int(11) NOT NULL,
  `tgl_bayar` date NOT NULL,
  `total_bayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `id_pesan` int(11) NOT NULL,
  `no_ktp` varchar(50) NOT NULL,
  `id_bayar` int(11) NOT NULL,
  `no_seat` varchar(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `tanggal_pesan` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` varchar(50) NOT NULL,
  `kode_booking` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- --------------------------------------------------------

--
-- Table structure for table `pesawat`
--

CREATE TABLE `pesawat` (
  `id_pesawat` varchar(50) NOT NULL,
  `id_maskapai` varchar(50) NOT NULL,
  `keterangan` varchar(255) NOT NULL,
  `rute` varchar(50) NOT NULL,
  `jumlah_seat` int(11) NOT NULL,
  `tipe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesawat`
--

INSERT INTO `pesawat` (`id_pesawat`, `id_maskapai`, `keterangan`, `rute`, `jumlah_seat`, `tipe`) VALUES
('GA-760', 'GA', 'Ready to Fly', 'Domestik', 367, '737-200');

-- --------------------------------------------------------

--
-- Table structure for table `r_penerbangan`
--

CREATE TABLE `r_penerbangan` (
  `id_penerbangan` int(11) NOT NULL,
  `id_jadwal` int(11) NOT NULL,
  `id_pesawat` varchar(50) NOT NULL,
  `id_bandara` varchar(50) NOT NULL,
  `tujuan` varchar(255) NOT NULL,
  `asal` varchar(255) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `bandara`
--
ALTER TABLE `bandara`
  ADD PRIMARY KEY (`id_bandara`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`no_ktp`);

--
-- Indexes for table `detilpesan`
--
ALTER TABLE `detilpesan`
  ADD PRIMARY KEY (`id_detilpesan`),
  ADD KEY `detilpesan_fk1` (`id_pesan`),
  ADD KEY `detilpesan_fk2` (`id_penerbangan`);

--
-- Indexes for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD PRIMARY KEY (`id_jadwal`);

--
-- Indexes for table `maskapai`
--
ALTER TABLE `maskapai`
  ADD PRIMARY KEY (`id_maskapai`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id_bayar`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id_pesan`),
  ADD KEY `pesanan_fk1` (`no_ktp`),
  ADD KEY `pesanan_fk2` (`id_bayar`);

--
-- Indexes for table `pesawat`
--
ALTER TABLE `pesawat`
  ADD PRIMARY KEY (`id_pesawat`),
  ADD KEY `pesawat_fk` (`id_maskapai`);

--
-- Indexes for table `r_penerbangan`
--
ALTER TABLE `r_penerbangan`
  ADD PRIMARY KEY (`id_penerbangan`),
  ADD KEY `rpenerbangan_fk1` (`id_jadwal`),
  ADD KEY `rpenerbangan_fk2` (`id_pesawat`),
  ADD KEY `rpenerbangan_fk3` (`id_bandara`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detilpesan`
--
ALTER TABLE `detilpesan`
  MODIFY `id_detilpesan` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `jadwal`
--
ALTER TABLE `jadwal`
  MODIFY `id_jadwal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id_bayar` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id_pesan` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `r_penerbangan`
--
ALTER TABLE `r_penerbangan`
  MODIFY `id_penerbangan` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `detilpesan`
--
ALTER TABLE `detilpesan`
  ADD CONSTRAINT `detilpesan_fk1` FOREIGN KEY (`id_pesan`) REFERENCES `pesanan` (`id_pesan`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detilpesan_fk2` FOREIGN KEY (`id_penerbangan`) REFERENCES `r_penerbangan` (`id_penerbangan`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `pesanan_fk1` FOREIGN KEY (`no_ktp`) REFERENCES `customer` (`no_ktp`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pesanan_fk2` FOREIGN KEY (`id_bayar`) REFERENCES `pembayaran` (`id_bayar`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pesawat`
--
ALTER TABLE `pesawat`
  ADD CONSTRAINT `pesawat_fk` FOREIGN KEY (`id_maskapai`) REFERENCES `maskapai` (`id_maskapai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `r_penerbangan`
--
ALTER TABLE `r_penerbangan`
  ADD CONSTRAINT `rpenerbangan_fk1` FOREIGN KEY (`id_jadwal`) REFERENCES `jadwal` (`id_jadwal`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rpenerbangan_fk2` FOREIGN KEY (`id_pesawat`) REFERENCES `pesawat` (`id_pesawat`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rpenerbangan_fk3` FOREIGN KEY (`id_bandara`) REFERENCES `bandara` (`id_bandara`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
