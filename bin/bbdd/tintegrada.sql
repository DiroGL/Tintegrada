-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-04-2023 a las 08:42:03
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

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
  `Ncom` int(11) NOT NULL,
  `cobertura` varchar(50) NOT NULL,
  `formaPago` varchar(50) NOT NULL,
  `telcom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE `ofertas` (
  `Ncom` int(11) NOT NULL,
  `lineas` int(11) NOT NULL,
  `precio` decimal(8,2) NOT NULL,
  `Ngigas` int(11) NOT NULL,
  `regalos` varchar(200) DEFAULT NULL,
  `DNIusuario` int(11) NOT NULL,
  `Nofer` int(11) NOT NULL,
  `permanencia` int(11) NOT NULL,
  `Nmegas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precontrato`
--

CREATE TABLE `precontrato` (
  `DNIusuario` int(11) NOT NULL,
  `Nofer` int(11) NOT NULL,
  `Ncom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `Ncom` int(11) NOT NULL,
  `300M` decimal(8,2) DEFAULT NULL,
  `500M` decimal(8,2) DEFAULT NULL,
  `600M` decimal(8,2) DEFAULT NULL,
  `800M` decimal(8,2) DEFAULT NULL,
  `1G` decimal(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `DNI` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

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
  ADD PRIMARY KEY (`Ncom`,`DNIusuario`),
  ADD KEY `DNIusuario` (`DNIusuario`);

--
-- Indices de la tabla `precontrato`
--
ALTER TABLE `precontrato`
  ADD PRIMARY KEY (`DNIusuario`,`Ncom`),
  ADD KEY `Ncom` (`Ncom`);

--
-- Indices de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`Ncom`);

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
  ADD CONSTRAINT `ofertas_ibfk_2` FOREIGN KEY (`DNIusuario`) REFERENCES `usuarios` (`DNI`);

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
