INSERT INTO `owners` (`id`, `date_of_birth`, `first_name`, `last_name`) VALUES ('1', '2000-10-10', 'Ivan', 'Tanev');
INSERT INTO `owners` (`id`, `date_of_birth`, `first_name`, `last_name`) VALUES ('2', '1990-11-11', 'Petar', 'Petrov');
INSERT INTO `owners` (`id`, `date_of_birth`, `first_name`, `last_name`) VALUES ('3', '1966-9-9', 'Georgi', 'Georgiev');

INSERT INTO `engines` (`id`, `cubature`, `hours_power`, `engine_number`) VALUES ('1', '1799', '122', '52WVC1033');
INSERT INTO `engines` (`id`, `cubature`, `hours_power`, `engine_number`) VALUES ('2', '1998', '306', '11WI11I');
INSERT INTO `engines` (`id`, `cubature`, `hours_power`, `engine_number`) VALUES ('3', '1000', '90', '22WWEP');

INSERT INTO `cars` (`id`, `brand`, `car_number`, `model`, `year_of_manufacture`, `owner_id`, `engine_id`) VALUES ('1', 'MERCEDES', 'РВ0014РА', 'W202', '1997', '1', '1');
INSERT INTO `cars` (`id`, `brand`, `car_number`, `model`, `year_of_manufacture`, `owner_id`, `engine_id`) VALUES ('2', 'BMW', 'РВ1234MK', '1er', '2019', '2', '2');
INSERT INTO `cars` (`id`, `brand`, `car_number`, `model`, `year_of_manufacture`, `owner_id`, `engine_id`) VALUES ('3', 'LADA', 'PA1111MP', 'Aerostar', '1980', '2', '3');
