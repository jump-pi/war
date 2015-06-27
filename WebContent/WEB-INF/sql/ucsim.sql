CREATE TABLE `ucsim` (
  `id_ucsim` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  `uri_template` varchar(100) NOT NULL,
  `http_method` varchar(50) DEFAULT NULL,
  `js_code` text,
  PRIMARY KEY (`id_ucsim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
