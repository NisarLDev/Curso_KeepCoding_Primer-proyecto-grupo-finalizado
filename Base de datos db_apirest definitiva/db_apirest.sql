-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-06-2022 a las 17:45:40
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
-- Base de datos: `db_apirest`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nif` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` int(11) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `email`, `nif`, `nombre`, `telefono`, `apellido`, `create_at`) VALUES
(1, 'jp@gmail.com', '54446442D', 'Juan', 6321122, 'Oller', '2022-06-16 00:00:00.000000'),
(2, 'mla@gmail.com', '54445442D', 'Maria', 6321122, 'ladelbarrio', '2022-06-16 00:00:00.000000'),
(3, 'jp3@gmail.com', '54444442D', 'Pepito', 6321122, 'Ruiz', '2022-06-16 00:00:00.000000'),
(4, 'jp2@gmail.com', '54436442D', 'Carlos', 6321122, 'Perez', '2022-06-16 00:00:00.000000'),
(5, 'jp1@gmail.com', '54442442D', 'Lola', 6321122, 'Pirez', '2022-06-16 00:00:00.000000'),
(6, 'jp43@gmail.com', '54441442D', 'Marcelo', 6321122, 'Rainiero', '2022-06-16 00:00:00.000000'),
(7, 'jp23@gmail.com', '54440442D', 'Leomar', 6321122, 'Leon', '2022-06-16 00:00:00.000000'),
(8, 'jp24@gmail.com', '54476442D', 'Cristino', 6321122, 'Rolando', '2022-06-16 00:00:00.000000'),
(9, 'jp14@gmail.com', '54448442D', 'Allegra', 6321122, 'kholl', '2022-06-16 00:00:00.000000'),
(10, 'jp424@gmail.com', '54449442D', 'Ragnar', 6321122, 'Loubrok', '2022-06-16 00:00:00.000000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` bigint(20) NOT NULL,
  `cod_producto` varchar(255) NOT NULL,
  `precio` double NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `cod_producto`, `precio`, `tipo`, `cantidad`, `fecha_registro`, `imagen`, `nombre`) VALUES
(1, '00001', 2, 'bebida', 6, '2022-06-16', '0d6d5132-10ee-4f16-a85c-773e32abdc5b_cocaCola.webp', 'cocacola'),
(2, '00002', 3, 'comida', 4, '2022-06-16', 'f8a4f736-05d6-416e-8797-ae1e1aa14b99_patatas.jpg', 'patatas'),
(3, '00003', 2, 'comida', 3, '2022-06-16', 'b35c4453-0b12-4dfb-9103-a4418202e23d_helados.jpg', 'helado'),
(4, '00004', 2, 'comida', 2, '2022-06-16', '5d406e35-8c03-4395-9a19-31dac4982321_arroz.jpg', 'arroz'),
(5, '00005', 5, 'mascota', 1, '2022-06-16', 'bdf2cab2-64b2-48de-897b-d8dec3c7d114_comidaPerros.webp', 'comida de perro'),
(6, '00006', 5, 'limpieza', 2, '2022-06-16', '7476c5bd-a887-43c2-8806-8c6924e1ee7d_lejia.jpg', 'lejía'),
(7, '00007', 3, 'comida', 2, '2022-06-16', '6c2eb66a-3188-4cc2-a7db-1636f8817abe_gazpacho.jpg', 'gazpacho'),
(8, '00008', 7, 'comida', 1, '2022-06-16', '463b83a2-008e-4c8c-a380-1edd61915fc8_pastel.jpg', 'pastel'),
(9, '00009', 9, 'comida', 4, '2022-06-16', 'f857de47-4c23-4cee-affc-ae249945029a_carne.jpg', 'carne'),
(10, '000010', 3, 'limpieza', 4, '2022-06-16', '89fad0c3-b648-45c3-a3d5-9e2c174f733c_bayeta.jpg', 'balleta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` bigint(20) NOT NULL,
  `create_at` datetime(6) DEFAULT NULL,
  `direccion` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nif` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `create_at`, `direccion`, `email`, `nif`, `nombre`, `telefono`) VALUES
(1, '2022-06-16 00:00:00.000000', 'c/Brasil num: 9 cp:64897', 'jsdp@gmail.com', 'Oller', 'Juan', 6321122),
(2, '2022-06-16 00:00:00.000000', 'c/Lora num: 56 cp:65497', 'mla@gmail.com', 'ladelbarrio', 'Maria', 6321122),
(3, '2022-06-16 00:00:00.000000', 'c/Coria num: 65 cp:65647', 'jfgjp@gmail.com', 'Ruiz', 'Pepito', 6321122),
(4, '2022-06-16 00:00:00.000000', 'c/ num: 94 cp:54989', 'jjlñp@gmail.com', 'Perez', 'Carlos', 6321122),
(5, '2022-06-16 00:00:00.000000', 'c/num:cp:35648', 'erjp@gmail.com', 'Pirez', 'Lola', 6321122),
(6, '2022-06-16 00:00:00.000000', 'c/Mendez num: 84 cp:65984', 'jjkñp@gmail.com', 'Rainiero', 'Marcelo', 6321122),
(7, '2022-06-16 00:00:00.000000', 'c/Lorca num: 34 cp:65899', 'jsep@gmail.com', 'Leon', 'Leomar', 6321122),
(8, '2022-06-16 00:00:00.000000', 'c/Velazquez num: 65 cp:65498', 'fvbnjp@gmail.com', 'Rolando', 'Cristino', 6321122),
(9, '2022-06-16 00:00:00.000000', 'c/Circo num: 35 cp:68796', 'jfghp@gmail.com', 'kholl', 'Allegra', 6321122);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `id` bigint(20) NOT NULL,
  `fecha_registro` date DEFAULT NULL,
  `total` bigint(20) NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `producto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_cmxo70m08n43599l3h0h07cc6` (`email`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_8s0y0k0p40dt6huwb8abeboj` (`cod_producto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ou6oi9246xevkpv4u4r0jge2t` (`email`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa7yaj59nfh3gft0h38o5bv472` (`cliente_id`),
  ADD KEY `FK1wljq30qekjupdmpom9laqr33` (`producto_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK1wljq30qekjupdmpom9laqr33` FOREIGN KEY (`producto_id`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `FKa7yaj59nfh3gft0h38o5bv472` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
