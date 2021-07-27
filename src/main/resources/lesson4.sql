CREATE SCHEMA `cinema` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE `cinema`.`movies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `duration` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cinema`.`sessions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_time` DATETIME NOT NULL,
  `price` DECIMAL(10,2) NULL,
  `movie_id` INT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `cinema`.`tickets` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `session_id` INT NOT NULL,
  `place` INT NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `cinema`.`movies` (`name`, `duration`) VALUES ('чёрная вдова', '120');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 10:00:00', '100', '1');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 12:30:00', '120', '1');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 15:00:00', '150', '1');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 17:30:00', '180', '1');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 20:00:00', '200', '1');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('1', '12');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('1', '23');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('1', '15');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('1', '44');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('1', '56');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('1', '30');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('1', '32');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('2', '11');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('2', '22');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('2', '17');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('2', '43');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('2', '51');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('3', '32');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('3', '43');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('3', '25');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('4', '14');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('4', '46');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('5', '20');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('5', '12');


INSERT INTO `cinema`.`movies` (`name`, `duration`) VALUES ('космический джем', '90');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 12:00:00', '120', '2');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 14:00:00', '140', '2');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 18:00:00', '180', '2');

INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('6', '22');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('6', '33');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('6', '25');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('6', '34');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('6', '46');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('7', '12');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('7', '21');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('7', '24');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('7', '16');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('7', '41');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('8', '34');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('8', '45');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('8', '28');

INSERT INTO `cinema`.`movies` (`name`, `duration`) VALUES ('лука', '60');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 11:30:00', '110', '3');
INSERT INTO `cinema`.`sessions` (`start_time`, `price`, `movie_id`) VALUES ('2021-07-21 14:30:00', '130', '3');

INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('9', '32');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('9', '23');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('9', '15');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('9', '14');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('9', '26');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('10', '22');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('10', '21');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('10', '24');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('10', '36');
INSERT INTO `cinema`.`tickets` (`session_id`, `place`) VALUES ('10', '11');


/* ошибки в расписании - не работают 
SELECT 
    m.name,
    s1.start_time,
    (s1.start_time + INTERVAL m.duration MINUTE) AS end_time
FROM
    cinema.sessions AS s1
        JOIN
    movies m ON m.id = s1.movie_id
WHERE
    s1.id IN (SELECT 
            id
        FROM
            cinema.sessions
        WHERE
            start_time >= s1.start_time
                AND start_time <= end_time);
*/
/* перерывы 30 минут и более между фильмами*/

??? просьба разобрать как сослаться в запросом на самого себя 

/* список фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей за сеанс и общей суммы сборов по каждому фильму */
SELECT 
    m.name, COUNT(t.id), AVG(s.price)
FROM
    movies m
        JOIN
    sessions s ON m.id = s.movie_id
        JOIN
    tickets t ON s.id = t.session_id
GROUP BY m.id;
/* число посетителей и кассовые сборы, сгруппированные по времени начала фильма*/
SELECT 
    m.name, COUNT(t.id), SUM(s.price)
FROM
    movies m
        JOIN
    sessions s ON m.id = s.movie_id
        JOIN
    tickets t ON s.id = t.session_id
WHERE
    HOUR(start_time) >= 9
        AND HOUR(start_time) <= 15
GROUP BY m.id
;