-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2021. Máj 12. 22:49
-- Kiszolgáló verziója: 10.4.13-MariaDB
-- PHP verzió: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `mindtech`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `album`
--

CREATE TABLE `album` (
  `id` bigint(20) NOT NULL,
  `cover_image_url` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `description` text COLLATE utf8_hungarian_ci DEFAULT NULL,
  `release_date` datetime NOT NULL,
  `title` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `artist_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `album`
--

INSERT INTO `album` (`id`, `cover_image_url`, `description`, `release_date`, `title`, `artist_id`) VALUES
(1, 'asdasdas', 'Leirasss', '2021-05-12 16:52:39', 'Cim1', 1),
(2, 'asdasdasd', 'Leiras2', '2021-05-12 16:53:02', 'Cim2', 1),
(3, 'asdada', 'Leiras3', '2021-05-12 16:53:25', 'Cim3', 2);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `artists`
--

CREATE TABLE `artists` (
  `id` bigint(20) NOT NULL,
  `biography` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `formed_year` datetime NOT NULL,
  `genre` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `name` varchar(255) COLLATE utf8_hungarian_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `artists`
--

INSERT INTO `artists` (`id`, `biography`, `formed_year`, `genre`, `name`) VALUES
(1, 'eletrajt', '2021-05-12 16:52:11', 'Rock', 'Valaki Valahol'),
(2, 'Élet', '2021-05-12 16:53:53', 'Pop', 'Valahol Valaki'),
(4, 'Rock', '2021-05-12 17:54:06', 'Rock', 'asdaddd'),
(5, 'asdasd', '2021-05-11 17:54:21', 'fff', 'fff fff'),
(6, 'rrr', '2021-05-12 17:54:34', 'rrr', 'rrr rrr'),
(7, 'ttttttt', '2021-05-12 17:54:50', 'ttt', 'ttt ttt'),
(8, 'aa', '2021-05-12 17:55:06', 'aaaa', 'aaa aaa'),
(9, 'sss', '2021-05-12 17:55:21', 'sss', 'sss ss'),
(10, 'ddd', '2021-05-12 17:55:36', 'dddd', 'ddd ddd'),
(11, 'ggg', '2021-05-12 17:55:51', 'ggggg', 'gg ggg'),
(12, 'hhh', '2021-05-12 17:56:19', 'hhh', 'hh hh'),
(13, 'jjj', '2021-05-12 17:56:33', 'jjj', 'jj jj');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `track`
--

CREATE TABLE `track` (
  `id` bigint(20) NOT NULL,
  `duration` double NOT NULL,
  `genre` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `title` varchar(255) COLLATE utf8_hungarian_ci NOT NULL,
  `album_album_id` bigint(20) DEFAULT NULL,
  `artist_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `track`
--

INSERT INTO `track` (`id`, `duration`, `genre`, `title`, `album_album_id`, `artist_id`) VALUES
(1, 150, 'Rock', 'Cim1', 1, 1),
(2, 200, 'Pop', 'Cim2', 1, 1);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `album`
--
ALTER TABLE `album`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiskbtqkyxyii6opkqri7fk6ts` (`artist_id`);

--
-- A tábla indexei `artists`
--
ALTER TABLE `artists`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `track`
--
ALTER TABLE `track`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4u0q3ql40drv12ts05bu54lwa` (`album_album_id`),
  ADD KEY `FKsqbsr2gbm4w9aidi3aeakmot3` (`artist_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `album`
--
ALTER TABLE `album`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT a táblához `artists`
--
ALTER TABLE `artists`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT a táblához `track`
--
ALTER TABLE `track`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
