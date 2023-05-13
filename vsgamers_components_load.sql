-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-05-2023 a las 23:32:12
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vsgamers_components`
--
CREATE DATABASE vsgamers_components;
-- --------------------------------------------------------
USE vsgamers_components;
--
-- Estructura de tabla para la tabla `graficas`
--

CREATE TABLE `graficas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `vram` int(11) NOT NULL,
  `marca` varchar(255) NOT NULL,
  `fabricante` varchar(255) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `graficas`
--

INSERT INTO `graficas` (`id`, `nombre`, `vram`, `marca`, `fabricante`, `precio`) VALUES
(4515, 'GeForce GTX 1050 Ti 4GT LP MSI ', 4, 'MSI', 'Nvidia', 199.9),
(6580, 'GeForce GTX 1650 Ventus XS 4G OC MSI ', 4, 'MSI', 'Nvidia', 220),
(7388, 'GeForce GTX 1660 SUPER Ventus XS OC 6 GB MSI ', 6, 'MSI', 'Nvidia', 257.77),
(7676, 'GeForce GTX 1660 SUPER 6GB OC GDDR6 Gigabyte ', 6, 'GIGABYTE', 'Nvidia', 349.9),
(8998, 'GeForce GTX 1650 D6 VENTUS XS OCV1 4GB GDDR6 MSI ', 4, 'MSI', 'Nvidia', 167.02),
(9154, 'NVIDIA Quadro P400 V2 2GB GDDR5 PNY ', 2, 'PNY', 'Nvidia', 148.07),
(9155, 'NVIDIA Quadro P400 DVI V2 2GB GDDR5 PNY ', 2, 'PNY', 'Nvidia', 143.73),
(9156, 'NVIDIA Quadro P1000 V2 4GB GDDR5 PNY ', 4, 'PNY', 'Nvidia', 352.48),
(9158, 'Quadro RTX 4000 8GB GDDR6 PNY ', 8, 'PNY', 'Nvidia', 1219.9),
(9174, 'Quadro RTX 5000 16GB GDDR6 PNY ', 16, 'PNY', 'Nvidia', 2199.9),
(9213, 'TUF Gaming GeForce GTX 1650 OC Edition 4GB GDDR6 Asus ', 4, 'ASUS', 'Nvidia', 259.9),
(9625, 'Radeon RX 6800 XT Gaming X Trio 16GB GDDR6 MSI ', 16, 'MSI', 'AMD', 1399.9),
(9642, 'GeForce GTX 1660 SUPER Twin Fan 6 GB GDDR6 Zotac ', 6, 'ZOTAC', 'Nvidia', 411.93),
(9654, 'TUF Gaming GeForce GTX 1650 4GB GDDR6 Asus ', 4, 'ASUS', 'Nvidia', 249.9),
(9725, 'Cerberus GeForce GTX 1050 Ti OC Edition 4 GB GDDR5 Asus ', 4, 'ASUS', 'Nvidia', 176.24),
(9811, 'GeForce GTX 1650 OC 4 GB GDDR6 Zotac ', 4, 'ZOTAC', 'Nvidia', 192.56),
(9817, 'Phoenix GeForce GTX 1050 Ti 4GB GDDR5 Asus ', 4, 'ASUS', 'Nvidia', 235.04),
(9906, 'Radeon RX 6800 XT Taichi OC 16 GB GDDR6 Asrock ', 16, 'ASROCK', 'AMD', 1379.9),
(9907, 'Phantom Gaming D OC Radeon RX 6800 Asrock ', 16, 'ASROCK', 'AMD', 1049.9),
(9965, 'Gigabyte Radeon RX 6800 XT GAMING OC Gigabyte ', 16, 'GIGABYTE', 'AMD', 858.06),
(9994, 'Cerberus GeForce GTX 1050 Ti Advanced Edition 4 GB GDDR5 Asus ', 4, 'ASUS', 'Nvidia', 196.95),
(10005, 'GeForce RTX 3060 VENTUS 2X OC 12GB GDDR6 MSI ', 12, 'MSI', 'Nvidia', 374.38),
(10073, 'GeForce RTX 3060 Gaming X 12GB GDDR6 MSI ', 12, 'MSI', 'Nvidia', 549.9),
(10074, 'GeForce RTX 3060 VENTUS 3X OC 12GB GDDR6 MSI ', 12, 'MSI', 'Nvidia', 524.9),
(10097, 'TUF Gaming GeForce GTX 1650 4GB GDDR6 Asus ', 4, 'ASUS', 'Nvidia', 209.24),
(10137, 'Phoenix Radeon RX 550 EVO 4GB GDDR5 Asus ', 4, 'ASUS', 'AMD', 118.54),
(10265, 'GeForce GT 1030 OC 2GB GDDR5 Asus ', 2, 'ASUS', 'Nvidia', 101.25),
(10866, 'Dual GeForce RTX 2060 EVO 6 GB GDDR6 Asus ', 6, 'ASUS', 'Nvidia', 490.71),
(11100, 'Dual Radeon RX 6700 XT 12GB GDDR6 Asus ', 12, 'ASUS', 'AMD', 434.02),
(11102, 'GeForce RTX 3070 Ti GAMING X TRIO 8G GDDR6X MSI ', 8, 'MSI', 'Nvidia', 932.85),
(11103, 'GeForce RTX 3070 Ti VENTUS 3X OC 8GB GDDR6 MSI ', 8, 'MSI', 'Nvidia', 889.9),
(11112, 'ROG Strix GeForce RTX 3070 Ti Gaming OC 8GB GDDR6X Asus ', 8, 'ASUS', 'Nvidia', 975.97),
(11116, 'TUF Gaming GeForce RTX 3070 Ti OC 8GB GDDR6X Asus ', 8, 'ASUS', 'Nvidia', 937.43),
(11133, 'GeForce RTX 3070 Ti AMP Holo 8GB GDDR6X Zotac ', 8, 'ZOTAC', 'Nvidia', 909.92),
(11150, 'Dual GeForce RTX 3060 LHR OC 12GB GDDR6 Asus ', 12, 'ASUS', 'Nvidia', 380.88),
(11197, 'GeForce RTX 3070 AMP Holo LHR 8GB GDDR6 Zotac ', 8, 'ZOTAC', 'Nvidia', 582.05),
(11198, 'Dual GeForce RTX 3060 12GB V2 GDDR6 Asus ', 12, 'ASUS', 'Nvidia', 412.76),
(11200, 'GeForce RTX 3070 Twin Edge OC White Edition LHR 8GB GDDR6 Zotac ', 8, 'ZOTAC', 'Nvidia', 556.85),
(11254, 'Phoenix GeForce RTX 3060 V2 12 GB GDDR6 Asus ', 12, 'ASUS', 'Nvidia', 367.2),
(11255, 'TUF Gaming GeForce RTX 3060 V2 OC 12GB GDDR6 Asus ', 12, 'ASUS', 'Nvidia', 484.01),
(11319, 'NVIDIA GeForce RTX 3070 Ti Trinity OC 8 GB GDDR6X Zotac ', 8, 'ZOTAC', 'Nvidia', 629.91),
(11320, 'NVIDIA Dual GeForce RTX 3060 Ti OC LHR 8GB GDDR6 Asus ', 8, 'ASUS', 'Nvidia', 535.29),
(11482, 'GeForce RTX 3060 TI VENTUS 2X 8G OC V1 LHR MSI ', 8, 'MSI', 'Nvidia', 510.27),
(11527, 'Dual GeForce RTX 3070 V2 OC 8GB GDDR6 Asus ', 8, 'ASUS', 'Nvidia', 695),
(11542, 'TUF Gaming GeForce RTX 3070 V2 OC 8GB GDDR6 Asus ', 8, 'ASUS', 'Nvidia', 634.76),
(11544, 'GeForce GT 1030 2GB GDDR5 Asus ', 2, 'ASUS', 'Nvidia', 94.5),
(11726, 'GeForce GT 730 2GB GDDR3 Low profile MSI ', 2, 'MSI', 'Nvidia', 67.19),
(11776, 'GeForce RTX 3070 EAGLE OC 8GB GDDR6- LHR Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 564.23),
(11938, 'GeForce RTX 3060 Ti Twin Edge LHR 8GB GDDR6 Zotac ', 8, 'ZOTAC', 'Nvidia', 443.37),
(11940, 'GeForce GTX 1650 D6 Windforce OC 4G rev. 2.0 Gigabyte ', 4, 'GIGABYTE', 'Nvidia', 469.9),
(11945, 'NVIDIA GeForce RTX 3070 GAMING OC LHR 8GB GDDR6 Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 549.12),
(11946, 'Radeon RX 6600 Mech 2X 8GB GDDR6 MSI ', 8, 'MSI', 'AMD', 414.95),
(11982, 'GeForce GT 1030 Low Profile D4 Gigabyte ', 4, 'GIGABYTE', 'Nvidia', 83.5),
(12008, 'Dual Radeon  RX 6600 XT OC Edition 8GB GDDR6 Asus ERROR ', 8, 'ASUS', 'AMD', 554.06),
(12060, 'Dual Radeon  RX 6600 8GB GDDR6 Asus ERROR ', 8, 'ASUS', 'AMD', 445.69),
(12211, 'GT 730 SL 2GD5 BRK Asus ', 2, 'ASUS', 'Nvidia', 72.25),
(12212, 'GT 1030 Aero ITX 2GB OC MSI ', 2, 'MSI', 'Nvidia', 104.77),
(12214, 'NVIDIA T1000 4GB GDDR6 PNY ', 4, 'PNY', 'Nvidia', 481.3),
(12250, 'GeForce RTX 3070 Ti GAMING OC 8G GDDR6X Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 764.73),
(12254, 'AORUS GeForce RTX 3070 MASTER 8G (rev. 2.0) Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 949.9),
(12256, 'GeForce RTX 3060 Ti EAGLE OC 8G (rev. 2.0) Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 532.4),
(12258, 'Radeon RX 6600 EAGLE 8G Gigabyte ', 8, 'GIGABYTE', 'AMD', 515.64),
(12324, 'AORUS GeForce RTX  3070 Ti MASTER 8G Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 899.9),
(12325, 'Radeon RX 6600 XT GAMING OC 8G Gigabyte ', 8, 'GIGABYTE', 'AMD', 556.33),
(12383, 'GeForce GTX 1650 OC Low Profile 4 GB Gigabyte ', 4, 'GIGABYTE', 'Nvidia', 203.12),
(12385, 'AORUS XTREME GeForce RTX  3070 Ti VISION OC 8G Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 899.9),
(12387, 'GeForce RTX 3060 EAGLE OC 12G (rev. 2.0) Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 403.35),
(12388, 'GeForce RTX 3060 VISION OC 12G (rev. 2.0) 12 GB GDDR6 Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 422.2),
(12441, 'GeForce RTX 3080 Ti VENTUS 3X 12G OC MSI ', 12, 'MSI', 'Nvidia', 1690.73),
(12442, 'GeForce RTX 3090 ArcticStorm 24GB GDDR6X Zotac ', 24, 'ZOTAC', 'Nvidia', 2599.9),
(12695, 'ROG Strix GeForce RTX 3050 OC Edition 8GB Asus ', 8, 'ASUS', 'Nvidia', 494.24),
(12697, 'Dual GeForce RTX 3050 OC Edition 8GB Asus ', 8, 'ASUS', 'Nvidia', 413.25),
(12699, 'Phoenix GeForce RTX 3050 8 GB GDDR6 Asus ', 8, 'ASUS', 'Nvidia', 298.41),
(12702, 'GeForce RTX 3050 Twin Edge OC Zotac ', 0, 'ZOTAC', 'Nvidia', 296.07),
(12753, 'Radeon RX 6500 XT Mech 2X OC 4GB GDDR6 MSI ', 4, 'MSI', 'AMD', 277.9),
(12831, 'GeForce RTX 3050 GAMING X LHR 8GB GDDR6 MSI ', 8, 'MSI', 'Nvidia', 317.3),
(12833, 'Radeon 6500 XT GAMING OC 4GB GDDR6 Gigabyte ', 6, 'GIGABYTE', 'AMD', 340.87),
(12835, 'GeForce RTX 3090 AMP Extreme Holo Zotac ', 0, 'ZOTAC', 'Nvidia', 2498.81),
(12850, 'Dual GeForce GTX 1650 4GB GDDR5 Asus ', 4, 'ASUS', 'Nvidia', 239.9),
(12880, 'GT730 4H SL 2GD5 Asus ', 2, 'ASUS', 'Nvidia', 78.74),
(13047, 'GeForce RTX 3050 EAGLE 8G GDDR6 Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 319.7),
(13313, 'Radeon RX 6400 Aero ITX 4GB GDDR6 MSI ', 4, 'MSI', 'AMD', 175.87),
(13358, 'Tarjeta gráfica Asus Phoenix Radeon RX 6400 4GB GDDR6 Asus ', 4, 'ASUS', 'AMD', 125.58),
(13844, 'TUF Gaming GeForce RTX 3050 OC Edition 8GB GDDR6 Asus ', 8, 'ASUS', 'Nvidia', 429.9),
(14061, 'Dual GeForce RTX 3060 Ti V2 MINI 8GB GDDR6 Asus ', 8, 'ASUS', 'Nvidia', 589.9),
(14062, 'GeForce RTX 3060 EAGLE 12GB GDDR6 Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 384.65),
(14089, 'GeForce RTX 3060 Gaming OC 12GB (Rev 2.0) Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 421.54),
(14278, 'TUF Gaming GeForce RTX 4090 OC Edition 24GB GDDR6X Asus ', 24, 'ASUS', 'Nvidia', 2228.9),
(14283, 'GeForce RTX 4090 GAMING X TRIO 24GB GDDR6X MSI ', 24, 'MSI', 'Nvidia', 2059.27),
(14306, 'GeForce RTX 3060 Windforce OC LHR 12GB GDDR6 Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 388.25),
(14309, 'GeForce RTX 3080 VENTUS 3X PLUS 10G OC LHR MSI ', 10, 'MSI', 'Nvidia', 912.15),
(14312, 'GeForce RTX 4090 GameRock 24GB GDDR6X Palit ', 24, 'PALIT', 'Nvidia', 2262.06),
(14316, 'Radeon RX 6650 XT Phantom Gaming D 8GB OC Asrock ', 8, 'ASROCK', 'AMD', 444.51),
(14317, 'RESPAWN Radeon RX 6500 XT Mech 2X OC 4GB GDDR6 MSI ', 4, 'MSI', 'AMD', 266.2),
(14318, 'GeForce RTX 3080 10GB XLR8 Gaming UPRISING EPIC-X RGB PNY ', 10, 'PNY', 'Nvidia', 862.28),
(14336, 'GeForce GT 1030 2 GB GDDR5 Asus ', 2, 'ASUS', 'Nvidia', 91.45),
(14347, 'GeForce RTX 4080 SUPRIM X 16GB GDDR6X MSI ', 16, 'MSI', 'Nvidia', 1553.22),
(14348, 'GeForce RTX 4080 GAMING X TRIO 16GB GDDR6X MSI ', 16, 'MSI', 'Nvidia', 1474.82),
(14374, 'Geforce RTX 3060 VENTUS 2X 8GB OC GDDR6 MSI ', 8, 'MSI', 'Nvidia', 346.55),
(14386, 'GeForce RTX 3060 Ti WINDFORCE OC 8G 8GB G Gigabyte ', 8, 'GIGABYTE', 'Nvidia', 577.93),
(14393, 'GeForce RTX 4070 Ti EAGLE OC 12G Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 972.99),
(14396, 'GeForce RTX 4070 Ti GAMING OC 12G GDDR6X Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 952.91),
(14397, 'GeForce RTX 4070 Ti 12GB GDDR6X PNY ', 12, 'PNY', 'Nvidia', 996.65),
(14398, 'Geforce RTX 4080 EAGLE OC 16GB GDDR6X Gigabyte ', 16, 'GIGABYTE', 'Nvidia', 1435.72),
(14399, 'ROG Strix GeForce RTX 4080 16GB GDDR6X Asus ', 16, 'ASUS', 'Nvidia', 1856.06),
(14407, 'GeForce RTX 3060 GAMING Z TRIO 12GB GDDR6 MSI ', 12, 'MSI', 'Nvidia', 440.76),
(14410, 'GeForce RTX 3060 TI VENTUS 2X OC 8GB GDDR6X MSI ', 8, 'MSI', 'Nvidia', 456.46),
(14411, 'TUF Gaming GeForce RTX 4080 16GB GDDR6 Asus ', 16, 'ASUS', 'Nvidia', 1509.09),
(14417, 'RESPAWM Radeon RX 6600 XT GAMING OC 8G Gigabyte ', 8, 'GIGABYTE', 'AMD', 556.6),
(14431, 'Radeon RX 7900 XT Gaming Trio Classic 20 GB MSI ', 20, 'MSI', 'AMD', 1048.23),
(14432, 'Radeon RX 7900 XT Gaming OC 20GB GDDR6 Gigabyte ', 20, 'GIGABYTE', 'AMD', 1045.91),
(14433, 'Geforce RTX 4090 GAMING OC 24GB Gigabyte ', 24, 'GIGABYTE', 'Nvidia', 1839.72),
(14435, 'AORUS GeForce RTX 4070 TI MASTER 12 GB GDDR6X Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 1056.54),
(14436, 'AORUS GeForce RTX 4070 Ti ELITE 12GB GDDR6X Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 1038.53),
(14438, 'Dual GeForce GTX 1650 V2 OC 4GB GDDR6 Asus ', 4, 'ASUS', 'Nvidia', 186.95),
(14439, 'Dual Geforce RTX 3060 Ti OC 8GB GDDR6X Asus ', 8, 'ASUS', 'Nvidia', 530.03),
(14442, 'GeForce RTX 4070 TI VENTUS 3X OC 12GB GDDR6X DLSS3 MSI ', 12, 'MSI', 'Nvidia', 936.58),
(14443, 'ROG Strix GeForce RTX 4070 Ti 12 GB GDDR6X Asus ', 12, 'ASUS', 'Nvidia', 1119.99),
(14459, 'ROG STRIX Radeon RX 6750 XT OC 12 GB GDDR6 Asus ', 12, 'ASUS', 'AMD', 605.96),
(14481, 'GeForce RTX 4090 GAMING Verto Edition 24GB GDDR6X PNY ', 24, 'PNY', 'Nvidia', 1895.23),
(14484, 'TUF Gaming Geforce RTX 4070 TI OC 12GB GDDR6X Asus ', 12, 'ASUS', 'Nvidia', 993.47),
(14503, 'TUF Gaming GeForce RTX 4070 12 GB GDDR6X Asus ', 12, 'ASUS', 'Nvidia', 833.85),
(14504, 'Dual GeForce RTX 4070 12 GB GDDR6X Asus ', 12, 'ASUS', 'Nvidia', 709.89),
(14526, 'Geforce RTX 4070 GAMING X TRIO 12GB GDDR6X MSI ', 12, 'MSI', 'Nvidia', 802.42),
(14527, 'Geforce RTX 4090 SUPRIM LIQUID X 24GB GDDR6X MSI ', 24, 'MSI', 'Nvidia', 2200.06),
(14540, 'GeForce RTX 4070 Ti GAMING X TRIO 12Gb GDDR6X MSI ', 12, 'MSI', 'Nvidia', 1044.76),
(14541, 'GeForce RTX 4070 GAMING OC 12Gb GDDR6X Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 691.8),
(14543, 'GeForce RTX 4090 VENTUS 3X OC 24GB GDDR6X MSI ', 24, 'MSI', 'Nvidia', 1834.1),
(14544, 'GeForce RTX 4090 WINDFORCE 24Gb GDDR6X Gigabyte ', 24, 'GIGABYTE', 'Nvidia', 1914.8),
(14545, 'GeForce RTX 4090 24GB XLR8 Gaming VERTO Epic-X GDDR6X PNY ', 24, 'PNY', 'Nvidia', 1942.58),
(14555, 'GeForce RTX 4090 SUPRIM X 24G GDDR6X DLSS3 MSI ', 24, 'MSI', 'Nvidia', 2119.74),
(14558, 'GeForce RTX 4070 VENTUS 3X OC 12GB GDDR6X DLSS3 MSI ', 12, 'MSI', 'Nvidia', 724.4),
(14560, 'DUAL GeForce RTX 3060 OC 8GB GDDR6 Asus ', 8, 'ASUS', 'Nvidia', 341.54),
(14576, 'Geforce RTX 4070 TI AERO OC 12G DDR6X Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 990.57),
(14577, 'GeForce RTX 4070 TI AMP Extreme AIRO 12GB GDDR6X Zotac ', 12, 'ZOTAC', 'Nvidia', 1044.87),
(14578, 'GeForce RTX 4070 AMP AIRO12 GB GDDR6X Zotac ', 12, 'ZOTAC', 'Nvidia', 747.63),
(14579, 'GeForce RTX 4070 AERO OC 12GB GDDR6X Gigabyte ', 12, 'GIGABYTE', 'Nvidia', 743.72);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `graficas`
--
ALTER TABLE `graficas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `graficas`
--
ALTER TABLE `graficas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14580;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
