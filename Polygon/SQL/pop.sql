--
-- inserts
--



INSERT INTO organisations (organisation_name) VALUES ('Polygon');
INSERT INTO organisations (organisation_name) VALUES ('Cphbusiness');
INSERT INTO organisations (organisation_name) VALUES ('DTU');
INSERT INTO organisations (organisation_name) VALUES ('Codan');



INSERT INTO users (organisations_id, user_type, username, password, user_email) VALUES ('1', 'admin', 'Admin', '6bd8937a8789a3e58489c4cfd514b1a7', 'admin@polygon.dk');
INSERT INTO users (organisations_id, user_type, username, password, user_email) VALUES ('1', 'tech', 'Timm', '6bd8937a8789a3e58489c4cfd514b1a7', 'timm@polygon.dk');
INSERT INTO users (organisations_id, user_type, username, password, user_email) VALUES ('2', 'cust', 'Peter', '6bd8937a8789a3e58489c4cfd514b1a7', 'peter@cphbusiness.dk');
INSERT INTO users (organisations_id, user_type, username, password, user_email) VALUES ('3', 'cust', 'Rasmus', '6bd8937a8789a3e58489c4cfd514b1a7', 'rasmus@dtu.dk');
INSERT INTO users (organisations_id, user_type, username, password, user_email) VALUES ('4', 'cust', 'Waqas', '6bd8937a8789a3e58489c4cfd514b1a7', 'waqas@codan.dk');





INSERT INTO buildings (organisations_id, building_name, street_address, zipcode, build_year, floor_area) VALUES ('2', 'Bygning 101', 'Anker Engelunds Vej 101', '2800', '1972', '31278');
INSERT INTO buildings (organisations_id, building_name, street_address, zipcode, build_year, floor_area) VALUES ('3', 'Cphbusiness Søerne', 'Nansensgade 19', '1366', '1970', '3320');
INSERT INTO buildings (organisations_id, building_name, street_address, zipcode, build_year, floor_area) VALUES ('4', 'Codanhus', 'Gammel kongevej 60', '1850', '1967', '7721');
