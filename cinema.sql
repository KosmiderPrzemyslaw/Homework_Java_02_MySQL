
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinemas_ex`
--

-- --------------------------------------------------------

--
-- Table structure for table `cinemas`
--

CREATE TABLE `cinemas` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `address` text COLLATE utf8_polish_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `cinemas`
--

INSERT INTO `cinemas` (`id`, `name`, `address`) VALUES
(1, 'Luna', 'ul. Marszałkowska 28'),
(2, 'Silver Screen Puławska', 'Centrum Europlex - ul. Puławska 17'),
(3, 'Iluzjon Filmoteki Narodowej', 'ul. Narbutta 50a'),
(4, 'Etnokino', 'Ul. Kredytowa 1, Warszawa'),
(5, 'Multikino Złote Tarasy', 'ul. Złota 59'),
(6, 'Kinoteka', 'pl. Defilad 1'),
(7, 'Cinema City Promenada', 'ul. Ostrobramska 75C'),
(8, 'Praha', 'ul. Jagielloñska 26'),
(9, 'Alchemia', 'ul. Jezuicka 4'),
(10, 'Muranów', 'ul. Zamenhofa 1'),
(11, 'Femina', 'al. Solidarności 115');

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `title` varchar(255) COLLATE utf8_polish_ci NOT NULL,
  `description` text COLLATE utf8_polish_ci,
  `rating` decimal(4,2) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `title`, `description`, `rating`) VALUES
(1, 'Zbuntowana (2015)', 'Beatrice Prior konfrontuje się z wewnętrznymi demonami i kontynuuje walkę przeciwko ogromnemu sojuszowi, który może spowodować rozpad społeczeństwa.', 7),
(2, 'Seks, miłość i terapia (2014)', 'Lambert, seksoholik starający się zerwać z nałogiem, zatrudnia wiecznie niezaspokojoną nimfomankę.', 5.00),
(3, 'Ex Machina (2015)', 'Po wygraniu konkursu programista jednej z największych firm internetowych zostaje zaproszony do posiadłości swojego szefa. Na miejsce okazuje się, że jest częścią eksperymentu. ', 8),
(4, 'Sils Maria (2014)', 'Wybitna aktorka podczas kilku dni spędzonych w Alpach ze swoją asystentką na nowo odkrywa siebie. ', 7.21),
(5, 'Chappie (2015)', 'Dwóch gangsterów kradnie policyjnego androida, by wykorzystać go do swoich celów. ', 8.32),
(6, 'Kopciuszek (2015)', 'Po śmierci ojca zła macocha Elli zamienia dziewczynę w służącą. Los Kopciuszka odmieni dopiero Dobra Wróżka.', 8),
(7, 'Sąsiady (2014)', 'Ksiądz odwiedza po kolędzie kamienicę, odkrywając tajemnice jej lokatorów. ', 3.15),
(8, 'Złota klatka (2013)', 'Sara, nastolatka z Gwatemali, wyrusza w niebezpieczną podróż do Los Angeles w poszukiwaniu lepszego życia.', 9),
(9, 'Body/Ciało (2015)', 'Cyniczny prokurator i jego cierpiąca na anoreksję córka próbują odnaleźć się po tragicznej śmierci najbliższej osoby.', 6),
(10, 'Fru! (2014)', 'Ptaszek, który nigdy wcześniej nie wychylił dzioba poza rodzinne gniazdo, zostaje przez pomyłkę przewodnikiem stada.', 5),
(11, 'Disco Polo (2015)', 'Młodzi muzycy z prowincji w błyskawiczny sposób zdobywają szczyty list przebojów.', 2),
(12, 'Asteriks i Obeliks: Osiedle Bogów (2014)', 'Juliusz Cezar decyduje się na budowę dzielnicy mieszkaniowej dla właścicieli rzymskich i nazywa ją Osiedlem Bogów.', 9);

-- --------------------------------------------------------

--
-- Table structure for table `tickets`
--

CREATE TABLE `tickets` (
  `id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL DEFAULT '0',
  `price` decimal(5,2) NOT NULL DEFAULT '0.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `tickets`
--

INSERT INTO `tickets` (`id`, `quantity`, `price`) VALUES
(1, 103, 37.4),
(2, 220, 24.99),
(3, 56, 42),
(4, 402, 17.21),
(5, 105, 28.32),
(6, 700, 20.5),
(7, 307, 23.15),
(8, 99, 49.5),
(9, 601, 36),
(10, 444, 25.5),
(11, 123, 21.9),
(12, 208, 19.9);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cinemas`
--
ALTER TABLE `cinemas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cinemas`
--
ALTER TABLE `cinemas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `tickets`
--
ALTER TABLE `tickets`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
