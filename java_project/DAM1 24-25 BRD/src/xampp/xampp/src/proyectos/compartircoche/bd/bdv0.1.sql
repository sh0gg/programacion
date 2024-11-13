
CREATE TABLE `user` ( 
  `id` INT AUTO_INCREMENT NOT NULL,
  `username` VARCHAR(250) NOT NULL,
  `password` VARCHAR(250) NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT current_timestamp() ,
  CONSTRAINT `PRIMARY` PRIMARY KEY (`id`),
  CONSTRAINT `UQ_user_username` UNIQUE (`username`)
);


CREATE TABLE `viaje` ( 
  `id` INT AUTO_INCREMENT NOT NULL,
  `usuario` VARCHAR(250) NOT NULL,
  `fecha_hora` DATETIME NOT NULL,
  `origen` VARCHAR(250) NOT NULL,
  `destino` VARCHAR(250) NOT NULL,
  `plazas` INT NOT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (`id`)
);

CREATE TABLE `pasajero` ( 
  `viaje` INT NOT NULL,
  `usuario` VARCHAR(250) NOT NULL,
  CONSTRAINT `PRIMARY` PRIMARY KEY (`viaje`, `usuario`),
);

INSERT INTO `user` (`id`, `username`, `password`, `created_at`) VALUES (1, 'aguado', '$2y$13$DE231eGe9Z2hiNgpdIsVE.CJP65clkYvRMGjFdlpug9Odw3OSZhTS', '2024-10-30 17:39:00');
INSERT INTO `viaje` (`id`, `usuario`, `fecha_hora`, `origen`, `destino`, `plazas`) VALUES (1, 'aguado', '2024-10-31 12:00:00', 'Ponte', 'Mar¡n', 3);
INSERT INTO `viaje` (`id`, `usuario`, `fecha_hora`, `origen`, `destino`, `plazas`) VALUES (2, 'aguado', '2024-11-05 07:40:00', 'Cangas', 'Mar¡n', 2);
INSERT INTO `viaje` (`id`, `usuario`, `fecha_hora`, `origen`, `destino`, `plazas`) VALUES (3, 'aguado', '2024-11-12 07:40:00', 'Praza de Galicia, Pontevedra', 'IES Chan do Monte, Mar¡n', 3);
ALTER TABLE `pasajero` ADD CONSTRAINT `FK_pasajero_viaje` FOREIGN KEY (`viaje`) REFERENCES `viaje` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;
INSERT INTO `pasajero` (`viaje`, `usuario`) VALUES (3, 'aguado');
