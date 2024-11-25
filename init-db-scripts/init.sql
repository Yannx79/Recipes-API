-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2024 a las 06:04:02
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_recipes_api`
--

CREATE DATABASE IF NOT EXISTS `db_recipes_api` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE `db_recipes_api`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `category_entity`
--

CREATE TABLE IF NOT EXISTS `category_entity` (
  `id` int(11) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `category` enum('APPETIZER','BEVERAGE','DESSERT','GLUTEN_FREE','MAIN_COURSE','SALAD','SNACK','SOUP','VEGAN','VEGETARIAN') DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `category_entity`
--

INSERT INTO `category_entity` (`id`, `active`, `category`, `description`) VALUES
(1, 1, 'APPETIZER', 'APPETIZER'),
(2, 1, 'SNACK', 'SNACK'),
(3, 1, 'SOUP', 'SOUP'),
(4, 1, 'VEGAN', 'VEGAN'),
(5, 1, 'VEGETARIAN', 'VEGETARIAN'),
(6, 1, 'BEVERAGE', 'BEVERAGE'),
(7, 1, 'DESSERT', 'DESSERT'),
(8, 1, 'GLUTEN_FREE', 'GLUTEN_FREE'),
(9, 1, 'MAIN_COURSE', 'MAIN_COURSE'),
(10, 1, 'SALAD', 'SALAD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredient_entity`
--

CREATE TABLE IF NOT EXISTS `ingredient_entity` (
  `id` int(11) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `measurement_unit_id` int(11) DEFAULT NULL,
  `recipe_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ingredient_entity`
--

INSERT INTO `ingredient_entity` (`id`, `description`, `measurement_unit_id`, `recipe_id`) VALUES
(41, 'Ingredient description 1', 5, 3),
(42, 'Ingredient description 2', 8, 7),
(43, 'Ingredient description 3', 12, 4),
(44, 'Ingredient description 4', 1, 10),
(45, 'Ingredient description 5', 15, 6),
(46, 'Ingredient description 6', 3, 8),
(47, 'Ingredient description 7', 2, 5),
(48, 'Ingredient description 8', 10, 2),
(49, 'Ingredient description 9', 7, 9),
(50, 'Ingredient description 10', 16, 11),
(51, 'Ingredient description 11', 4, 3),
(52, 'Ingredient description 12', 14, 7),
(53, 'Ingredient description 13', 11, 5),
(54, 'Ingredient description 14', 20, 6),
(55, 'Ingredient description 15', 2, 10),
(56, 'Ingredient description 16', 9, 4),
(57, 'Ingredient description 17', 13, 8),
(58, 'Ingredient description 18', 5, 2),
(59, 'Ingredient description 19', 6, 9),
(60, 'Ingredient description 20', 19, 11),
(61, 'Ingredient description 21', 8, 1),
(62, 'Ingredient description 22', 2, 12),
(63, 'Ingredient description 23', 17, 15),
(64, 'Ingredient description 24', 4, 14),
(65, 'Ingredient description 25', 14, 18),
(66, 'Ingredient description 26', 5, 13),
(67, 'Ingredient description 27', 9, 20),
(68, 'Ingredient description 28', 11, 17),
(69, 'Ingredient description 29', 7, 19),
(70, 'Ingredient description 30', 16, 16),
(71, 'Ingredient description 31', 3, 4),
(72, 'Ingredient description 32', 12, 6),
(73, 'Ingredient description 33', 1, 7),
(74, 'Ingredient description 34', 15, 2),
(75, 'Ingredient description 35', 20, 5),
(76, 'Ingredient description 36', 18, 9),
(77, 'Ingredient description 37', 13, 10),
(78, 'Ingredient description 38', 6, 8),
(79, 'Ingredient description 39', 9, 11),
(80, 'Ingredient description 40', 10, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `measurement_unit_entity`
--

CREATE TABLE IF NOT EXISTS `measurement_unit_entity` (
  `id` int(11) NOT NULL,
  `abbreviation` varchar(120) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `description` varchar(120) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `measurement_unit_entity`
--

INSERT INTO `measurement_unit_entity` (`id`, `abbreviation`, `active`, `description`) VALUES
(1, 'kg', 1, 'Kilogram'),
(2, 'g', 1, 'Gram'),
(3, 'lb', 1, 'Pound'),
(4, 'oz', 0, 'Ounce'),
(5, 'm', 1, 'Meter'),
(6, 'cm', 0, 'Centimeter'),
(7, 'mm', 1, 'Millimeter'),
(8, 'in', 1, 'Inch'),
(9, 'ft', 0, 'Foot'),
(10, 'yd', 1, 'Yard'),
(11, 'km', 1, 'Kilometer'),
(12, 'mi', 0, 'Mile'),
(13, 'l', 1, 'Liter'),
(14, 'ml', 0, 'Milliliter'),
(15, 'gal', 1, 'Gallon'),
(16, 'pt', 0, 'Pint'),
(17, 'qt', 1, 'Quart'),
(18, 'tbsp', 1, 'Tablespoon'),
(19, 'tsp', 0, 'Teaspoon'),
(20, 'fl oz', 1, 'Fluid Ounce');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `product_entity`
--

CREATE TABLE IF NOT EXISTS `product_entity` (
  `id` int(11) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `enter_date` date DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `measurement_unit_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `product_entity`
--

INSERT INTO `product_entity` (`id`, `description`, `enter_date`, `name`, `category_id`, `measurement_unit_id`) VALUES
(1, 'Product description 1', '2024-11-01', 'Product 1', 3, 15),
(2, 'Product description 2', '2024-10-25', 'Product 2', 5, 12),
(3, 'Product description 3', '2024-10-15', 'Product 3', 1, 8),
(4, 'Product description 4', '2024-09-20', 'Product 4', 7, 18),
(5, 'Product description 5', '2024-09-01', 'Product 5', 2, 4),
(6, 'Product description 6', '2024-08-15', 'Product 6', 10, 1),
(7, 'Product description 7', '2024-08-10', 'Product 7', 4, 6),
(8, 'Product description 8', '2024-08-05', 'Product 8', 6, 20),
(9, 'Product description 9', '2024-07-25', 'Product 9', 9, 17),
(10, 'Product description 10', '2024-07-10', 'Product 10', 8, 2),
(11, 'Product description 11', '2024-11-01', 'Product 1', 3, 15),
(12, 'Product description 12', '2024-10-25', 'Product 2', 5, 12),
(13, 'Product description 13', '2024-10-15', 'Product 3', 1, 8),
(14, 'Product description 14', '2024-09-20', 'Product 4', 7, 18),
(15, 'Product description 15', '2024-09-01', 'Product 5', 2, 4),
(16, 'Product description 16', '2024-08-15', 'Product 6', 10, 1),
(17, 'Product description 17', '2024-08-10', 'Product 7', 4, 6),
(18, 'Product description 18', '2024-08-05', 'Product 8', 6, 20),
(19, 'Product description 19', '2024-07-25', 'Product 9', 9, 17),
(20, 'Product description 20', '2024-07-10', 'Product 10', 8, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recipe_entity`
--

CREATE TABLE IF NOT EXISTS `recipe_entity` (
  `id` int(11) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `recipe_entity`
--

INSERT INTO `recipe_entity` (`id`, `description`, `product_id`) VALUES
(1, 'Recipe description 1', 1),
(2, 'Recipe description 2', 2),
(3, 'Recipe description 3', 3),
(4, 'Recipe description 4', 4),
(5, 'Recipe description 5', 5),
(6, 'Recipe description 6', 6),
(7, 'Recipe description 7', 7),
(8, 'Recipe description 8', 8),
(9, 'Recipe description 9', 9),
(10, 'Recipe description 10', 10),
(11, 'Recipe description 11', 11),
(12, 'Recipe description 12', 12),
(13, 'Recipe description 13', 13),
(14, 'Recipe description 14', 14),
(15, 'Recipe description 15', 15),
(16, 'Recipe description 16', 16),
(17, 'Recipe description 17', 17),
(18, 'Recipe description 18', 18),
(19, 'Recipe description 19', 19),
(20, 'Recipe description 20', 20);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `category_entity`
--
ALTER TABLE `category_entity`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ingredient_entity`
--
ALTER TABLE `ingredient_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKnqbwpj5c55q242q8wr5clmvy3` (`measurement_unit_id`),
  ADD KEY `FKlkts737tkjjbkry1vyp05mg2d` (`recipe_id`);

--
-- Indices de la tabla `measurement_unit_entity`
--
ALTER TABLE `measurement_unit_entity`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `product_entity`
--
ALTER TABLE `product_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8kxxmqdokh3lthvw0t148w0bc` (`category_id`),
  ADD KEY `FKsg451hojhnaj5xx7o4y0ko1w` (`measurement_unit_id`);

--
-- Indices de la tabla `recipe_entity`
--
ALTER TABLE `recipe_entity`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKcdm5c4xb4hff9g630wio2jv0k` (`product_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `category_entity`
--
ALTER TABLE `category_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `ingredient_entity`
--
ALTER TABLE `ingredient_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT de la tabla `measurement_unit_entity`
--
ALTER TABLE `measurement_unit_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `product_entity`
--
ALTER TABLE `product_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `recipe_entity`
--
ALTER TABLE `recipe_entity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ingredient_entity`
--
ALTER TABLE `ingredient_entity`
  ADD CONSTRAINT `FKlkts737tkjjbkry1vyp05mg2d` FOREIGN KEY (`recipe_id`) REFERENCES `recipe_entity` (`id`),
  ADD CONSTRAINT `FKnqbwpj5c55q242q8wr5clmvy3` FOREIGN KEY (`measurement_unit_id`) REFERENCES `measurement_unit_entity` (`id`);

--
-- Filtros para la tabla `product_entity`
--
ALTER TABLE `product_entity`
  ADD CONSTRAINT `FK8kxxmqdokh3lthvw0t148w0bc` FOREIGN KEY (`category_id`) REFERENCES `category_entity` (`id`),
  ADD CONSTRAINT `FKsg451hojhnaj5xx7o4y0ko1w` FOREIGN KEY (`measurement_unit_id`) REFERENCES `measurement_unit_entity` (`id`);

--
-- Filtros para la tabla `recipe_entity`
--
ALTER TABLE `recipe_entity`
  ADD CONSTRAINT `FKm4vg8mx5lll5nriics3opwq0y` FOREIGN KEY (`product_id`) REFERENCES `product_entity` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;