
INSERT INTO user (user_id, is_archived, created_by, created_date, modified_by, modified_date, email, first_name, last_name, password, isd_code, phone_number, user_name,active,register_via)VALUES ('1', '0', 1, '2017-10-31 13:25:44', 1, '2017-10-31 13:25:44', 'admin@ngex.com', 'Admin', 'Admin', '$2a$10$1wwc.Zi/lCPKWebtdQIMIef1DeQ4rtxufPVl216opjZsuHCHZNp/m','+91', '9569449099', 'Admin','1',1);

INSERT INTO role (role_id, role_name, description) VALUES (1, 'ADMIN', 'Admin User - Has permission to perform admin tasks');
INSERT INTO role (role_id, role_name, description) VALUES (2, 'USER', 'Standard User - Has no admin rights');


INSERT INTO user_role (user_role_id, role_id, user_id) VALUES ('1', '1', '1');
INSERT INTO user_role (user_role_id, role_id, user_id) VALUES ('2', '2', '1');
