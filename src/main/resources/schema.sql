CREATE TABLE postcodelatlng
(
    id          INT             NOT NULL AUTO_INCREMENT,
    postcode    VARCHAR(9)      NOT NULL,
    latitude    DECIMAL(10,7)   NULL,
    longitude   DECIMAL(10,7)   NULL,
    PRIMARY KEY (id)
);