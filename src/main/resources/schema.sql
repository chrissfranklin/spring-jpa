CREATE SCHEMA IF NOT EXISTS h2db;

CREATE TABLE IF NOT EXISTS t_preference
(
  id               INT AUTO_INCREMENT PRIMARY KEY,
  user_id          INT NOT NULL,
  practice_id      INT NOT NULL,
  report_name      VARCHAR(64)  NOT NULL,
  preference_name  VARCHAR(64)  NOT NULL,
  preference_value VARCHAR(64)  NOT NULL
)