CREATE USER merjem WITH PASSWORD 'mejameja98';
CREATE SCHEMA IF NOT EXISTS prevoz
    AUTHORIZATION postgres;
GRANT ALL PRIVILEGES ON SCHEMA prevoz TO  merjem;
    GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA prevoz TO  merjem;
CREATE TABLE prevoz.user
(
    user_id  bigint PRIMARY KEY     NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    username character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    role     character varying(255) NOT NULL
);
CREATE TABLE prevoz.bus
(
    bus_id       bigint PRIMARY KEY     NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    bus_number       bigint                 NOT NULL,
    start_station character varying(255) NOT NULL,
    end_station   character varying(255) NOT NULL
);
CREATE TABLE prevoz.minibus
(
    minibus_id      bigint PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    minibus_number        bigint,
    start_station character varying(500),
    end_station   character varying(500)
);
CREATE TABLE prevoz.ticket
(
    ticket_id   bigint PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    user_id     bigint,
    start_date  character varying(255),
    expiry_date character varying(255),
    FOREIGN KEY (user_id) REFERENCES prevoz.user (user_id)
);
CREATE TABLE prevoz.tram
(
    tram_id      bigint PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    tram_number        bigint,
    start_station character varying(255),
    end_station   character varying(255)
);
CREATE TABLE prevoz.trolley
(
    trolley_id      bigint PRIMARY KEY NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    trolley_number        bigint,
    start_station character varying(255),
    end_station   character varying(255)
);
CREATE TABLE prevoz.clock
(
    clock_id    bigint PRIMARY KEY     NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    tram_id     bigint,
    trolley_id  bigint,
    bus_id      bigint,
    minibus_id bigint,
    time        character varying(255) NOT NULL,
    FOREIGN KEY (tram_id) REFERENCES prevoz.tram (tram_id),
    FOREIGN KEY (trolley_id) REFERENCES prevoz.trolley (trolley_id),
    FOREIGN KEY (bus_id) REFERENCES prevoz.bus (bus_id),
    FOREIGN KEY (minibus_id) REFERENCES prevoz.minibus (minibus_id)
);


CREATE TABLE prevoz.station
(
    station_id  bigint PRIMARY KEY     NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    tram_id     bigint,
    trolley_id  bigint,
    bus_id      bigint,
    minibus_id bigint,
    name        character varying(255) NOT NULL,
    FOREIGN KEY (tram_id) REFERENCES prevoz.tram (tram_id),
    FOREIGN KEY (trolley_id) REFERENCES prevoz.trolley (trolley_id),
    FOREIGN KEY (bus_id) REFERENCES prevoz.bus (bus_id),
    FOREIGN KEY (minibus_id) REFERENCES prevoz.minibus (minibus_id)
);

GRANT USAGE ON SCHEMA prevoz TO merjem ;
GRANT ALL PRIVILEGES ON TABLE prevoz.user TO merjem;
GRANT ALL PRIVILEGES ON TABLE prevoz.bus TO merjem;
GRANT ALL PRIVILEGES ON TABLE prevoz.minibus TO merjem;
GRANT ALL PRIVILEGES ON TABLE prevoz.ticket TO merjem;
GRANT ALL PRIVILEGES ON TABLE prevoz.tram TO merjem;
GRANT ALL PRIVILEGES ON TABLE prevoz.trolley TO merjem;
GRANT ALL PRIVILEGES ON TABLE prevoz.clock TO merjem;
GRANT ALL PRIVILEGES ON TABLE prevoz.station TO merjem;

INSERT INTO prevoz.user (user_id, username, password, role)
VALUES (1, 'merjemcernica', 'mejameja', 'ADMIN'),
       (2, 'saidahrnjic', 'idaida', 'ADMIN'),
       (3, 'fariscernica', 'farefare', 'USER'),
       (4, 'bakirhajric', 'bakebake', 'USER'),
       (5, 'eminazubcevic', 'minamina', 'USER');

INSERT INTO prevoz.ticket (ticket_id, user_id, start_date, expiry_date)
VALUES (1, 3, '6.5.2022', '6.6.2022'),
       (2, 4, '25.7.2022', '25.8.2022'),
       (3, 5, '8.7.2022', '8.8.2022');


INSERT INTO prevoz.minibus (minibus_id, minibus_number, start_station, end_station)
VALUES (1, 51, 'Bascarsija', 'Vratnik'),
       (2, 52, 'Bascarsija', 'Faletici'),
       (3, 55, 'Bascarsija', 'Sedrenik'),
       (4, 58, 'Bascarsija', 'Mihrivode'),
       (5, 56, 'Latinska Cuprija', 'Jarcedoli'),
       (6, 63, 'Latinska Cuprija', 'Mahmutovac');

INSERT INTO prevoz.bus (bus_id, bus_number, start_station, end_station)
VALUES (1, 31, 'Vijecnica', 'Dobrinja'),
       (2, 27, 'Bascarsija', 'Hrasnica'),
       (3, 1, 'Bascarsija', 'Zeljeznicka stanica'),
       (4, 58, 'Bascarsija', 'Mihrivode');

INSERT INTO prevoz.tram (tram_id, tram_number, start_station, end_station)
VALUES (1, 3, 'Bascarsija', 'Ilidza'),
       (2, 2, 'Bascarsija', '??engic Vila'),
       (3, 4, 'Zeljeznicka stanica', 'Ilidza'),
       (4, 5, 'Bascarsija', 'Ned??arici'),
       (5, 6, 'Skenderija', 'Ilid??a');

INSERT INTO prevoz.trolley (trolley_id, trolley_number, start_station, end_station)
VALUES (1, 101, 'Trg Austrije', 'Otoka'),
       (2, 102, 'Otoka', 'Jezero'),
       (3, 103, 'Trg Austrije', 'Dobrinja'),
       (4, 104, 'Trg Austrije', 'Alipasino polje'),
       (5, 105, 'Dobrinja', 'Jezero');

INSERT INTO prevoz.station (station_id, tram_id, trolley_id, bus_id, minibus_id, name)
VALUES (1, 1, 1, 1, 1, 'Bascarsija'),
       (2, 2, 2, 2, 2, 'Ilidza'),
       (3, 3, 3, 3, 3, 'Otoka');

INSERT INTO prevoz.clock (clock_id, tram_id, trolley_id, bus_id, minibus_id, time)
VALUES (1, 1, 1, 1, 1, '12:00'),
       (2, 2, 2, 2, 2, '19:05'),
       (3, 3, 3, 3, 3, '13:06');