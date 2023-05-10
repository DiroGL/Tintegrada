-- phpMyAdmin SQL Dump
-- version 5.1.1deb5ubuntu1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 03-05-2023 a las 13:04:15
-- Versión del servidor: 8.0.32-0ubuntu0.22.04.2
-- Versión de PHP: 8.1.2-1ubuntu2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Entornos`
--

-- ------------------------------------------a--------------

--
-- Estructura de tabla para la tabla `compañias`
--

CREATE TABLE `compañias` (
  `Ncom` varchar(20) NOT NULL,
  `cobertura` varchar(50) NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `telcom` varchar(20) NOT NULL
);

--
-- Volcado de datos para la tabla `compañias`
--

INSERT INTO `compañias` (`Ncom`, `cobertura`, `formaPago`, `telcom`) VALUES
('MasMovil', 'COBERTURA', 'Tarjeta de crédito o débito, o transferencia', '900835766'),
('Movistar', 'COBERTURA', 'Tarjeta de crédito o débito', '900600253'),
('Orange', 'COBERTURA', 'Tarjeta de crédito o por transferencia', '1471'),
('Pepephone', 'COBERTURA', 'Tarjeta de credito o por transferencia', '1706'),
('Vodafone', 'COBERTURA', 'Tarjeta de crédito o débito', '900926689'),
('Yazztel', 'COBERTURA', 'Tarjeta o por transferencia', '1565'),
('Yoigo', 'COBERTURA', 'Tarjeta de crédito o débito', '622');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE `ofertas` (
  `Ncom` varchar(20) NOT NULL,
  `lineas` int NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `Ngigas` int NOT NULL,
  `regalos` varchar(200) DEFAULT NULL,
 
  `Nofer` int NOT NULL,
  `permanencia` int NOT NULL,
  `Nmegas` int NOT NULL
);

--
-- Volcado de datos para la tabla `ofertas`
--

INSERT INTO `ofertas` (`Ncom`, `lineas`, `precio`, `Ngigas`, `regalos`, `Nofer`, `permanencia`, `Nmegas`) VALUES
('Movistar', 1, '33.90', 1000, 'null',  1, 1, 600),
('Orange', 1, '30.95', 100, 'null',  2, 2, 500),
('Yazztel', 1, '28.95', 90, 'null', 3, 1, 300),
('Yoigo', 1, '47.00', 1000, 'null', 4, 2, 1000),
('Pepephone', 1, '50.90', 300, 'null', 5, 0, 800);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precontrato`
--

CREATE TABLE `precontrato` (
  `DNIusuario` varchar(9) NOT NULL,
  `Nofer` int NOT NULL,
  `Ncom` varchar(20) NOT NULL
);

--
-- Volcado de datos para la tabla `precontrato`
--

INSERT INTO `precontrato` (`DNIusuario`, `Nofer`, `Ncom`) VALUES
('12345678A', 1, 'Movistar'),
('23456789A', 2, 'Orange'),
('34557891A', 3, 'Yazztel'),
('34567891A', 4, 'Yoigo'),
('34567895A', 5, 'Pepephone');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `Ncom` varchar(20) NOT NULL,
  `300M` decimal(8,2) DEFAULT NULL,
  `500M` decimal(8,2) DEFAULT NULL,
  `600M` decimal(8,2) DEFAULT NULL,
  `800M` decimal(8,2) DEFAULT NULL,
  `1G` decimal(8,2) DEFAULT NULL
);

--
-- Volcado de datos para la tabla `tarifa`
--

INSERT INTO `tarifa` (`Ncom`, `300M`, `500M`, `600M`, `800M`, `1G`) VALUES
('Movistar', '29.90', NULL, '33.90', NULL, '43.90'),
('Yoigo', '32.00', NULL, '42.00', NULL, '47.00'),
('Yazztel', '28.95', NULL, '32.95', NULL, '33.95'),
('Pepephone', NULL, '42.90', NULL, '50.90', NULL),
('MasMovil', '24.99', NULL, '29.99', NULL, '34.99'),
('Orange', NULL, NULL, '30.40', NULL, '41.30');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `DNI` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
);

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`DNI`, `nombre`, `apellidos`, `telefono`, `correo`, `password`) VALUES
('12345678A', 'German', 'Martin Fernandez', '678 34 69 74', 'ger@gmail.com', '1234'),
('23456789A', 'Alejandro', 'Tenorio', '645 76 34 23', 'teno@gmail.com', '1234'),
('34557891A', 'Ilias', 'Amezou', '666 23 67 34', 'ilias@gmail.com', '1234'),
('34567891A', 'Oscar', 'Garcia Otermin', '685 45 56 64', 'oscar@gmail.com', '1234'),
('34567895A', 'Diego', 'Rodriguez', '678 98 23 24', 'diego@gmail.com', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compañias`
--
ALTER TABLE `compañias`
  ADD PRIMARY KEY (`Ncom`);

--
-- Indices de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD KEY `Ncom` (`Ncom`),

--
-- Indices de la tabla `precontrato`
--
ALTER TABLE `precontrato`
  ADD KEY `DNIusuario` (`DNIusuario`),
  ADD KEY `Ncom` (`Ncom`);

--
-- Indices de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD KEY `Ncom` (`Ncom`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`DNI`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD CONSTRAINT `ofertas_ibfk_1` FOREIGN KEY (`Ncom`) REFERENCES `compañias` (`Ncom`),


--
-- Filtros para la tabla `precontrato`
--
ALTER TABLE `precontrato`
  ADD CONSTRAINT `precontrato_ibfk_1` FOREIGN KEY (`DNIusuario`) REFERENCES `usuarios` (`DNI`),
  ADD CONSTRAINT `precontrato_ibfk_2` FOREIGN KEY (`Ncom`) REFERENCES `compañias` (`Ncom`);

--
-- Filtros para la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD CONSTRAINT `tarifa_ibfk_1` FOREIGN KEY (`Ncom`) REFERENCES `compañias` (`Ncom`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
