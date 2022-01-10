INSERT INTO users (id_user, username, password, enabled) VALUES (1, 'john', '$2a$10$.9YYvxt5XeMc2fUfBgezGewRoworLG0yfNZ4kWM6Wj9.GHFcM6SuC', 1);
INSERT INTO users (id_user, username, password, enabled) VALUES (2, 'set', '$2a$10$zNbdP65FWTP8Ml5UemNGT.ThJW9kFT6o5.pmOStFIzn8sZPIfC.66', 1);
INSERT INTO users (id_user, username, password, enabled) VALUES (3, 'rick', '$2a$10$kGxXv.IR66Z4h/L1.KmcvOo7hVU6o4VY7TFnyNhrX8fayc3f7K/Ra', 1);


INSERT INTO roles (id_role, role_name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id_role, role_name) VALUES (2, 'ROLE_USER');


#INSERT INTO users_roles (user_id_user, roles_id_role) VALUES (1, 1);
#INSERT INTO users_roles (user_id_user, roles_id_role) VALUES (1, 2);
#INSERT INTO users_roles (user_id_user, roles_id_role) VALUES (2, 1);
#INSERT INTO users_roles (user_id_user, roles_id_role) VALUES (2, 2);
#INSERT INTO users_roles (user_id_user, roles_id_role) VALUES (3, 2);

INSERT INTO user_authorities (user_id, role_id) VALUES (1, 1);
INSERT INTO user_authorities (user_id, role_id) VALUES (1, 2);
INSERT INTO user_authorities (user_id, role_id) VALUES (2, 2);
INSERT INTO user_authorities (user_id, role_id) VALUES (3, 2);



