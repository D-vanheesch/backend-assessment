
INSERT INTO users (username, password, enabled) VALUES ('user1', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('admin1', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('peter1', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('mechanic', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;

INSERT INTO authorities (username, authority) VALUES ('user1', 'ROLE_USER') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('admin1', 'ROLE_USER') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('admin1', 'ROLE_ADMIN') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('peter1', 'ROLE_USER') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('mechanic', 'ROLE_MECHANIC') on conflict (username, authority) do nothing;