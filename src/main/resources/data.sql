
INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('mechanic', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('frontdesk', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('backoffice', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;
INSERT INTO users (username, password, enabled) VALUES ('administration', '$2a$10$wPHxwfsfTnOJAdgYcerBt.utdAvC24B/DWfuXfzKBSDHO0etB1ica', TRUE) on conflict (username) do nothing;

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_USER') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('mechanic', 'ROLE_MECHANIC') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('frontdesk', 'ROLE_FRONTDESK') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('backoffice', 'ROLE_BACKOFFICE') on conflict (username, authority) do nothing;
INSERT INTO authorities (username, authority) VALUES ('administration', 'ROLE_ADMINISTRATION') on conflict (username, authority) do nothing;