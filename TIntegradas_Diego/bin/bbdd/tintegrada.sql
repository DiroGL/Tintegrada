-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-05-2023 a las 21:49:18
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tintegrada`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compañias`
--

CREATE TABLE `compañias` (
  `Ncom` varchar(20) NOT NULL,
  `cobertura` varchar(50) NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `telcom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compañias`
--

INSERT INTO `compañias` (`Ncom`, `cobertura`, `formaPago`, `telcom`) VALUES
('MasMovil', 'COBERTURA', 'Tarjeta de crédito o débito, o transferencia', '900835766'),
('Movistar', 'COBERTURA', 'Tarjeta de crédito o débito', '900600253'),
('Orange', 'COBERTURA', 'Tarjeta de crédito o por transferencia', '1471'),
('Pepephone', 'COBERTURA', 'Tarjeta de credito o por transferencia', '1706'),
('Yazztel', 'COBERTURA', 'Tarjeta o por transferencia', '1565'),
('Yoigo', 'COBERTURA', 'Tarjeta de crédito o débito', '622');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compañias`
--
ALTER TABLE `compañias`
  ADD PRIMARY KEY (`Ncom`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
