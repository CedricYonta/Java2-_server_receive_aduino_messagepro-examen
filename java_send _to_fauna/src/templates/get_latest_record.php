<?php
// Paramètres de connexion à la base de données
$host = 'localhost';
$dbname = 'dvdrental';
$user = 'postgres';
$password = 'cedric';

// Connexion à la base de données
$dsn = "pgsql:host=$host;dbname=$dbname;user=$user;password=$password";
$db = new PDO($dsn);

// Exécution de la requête SQL pour récupérer le dernier enregistrement
$stmt = $db->query("SELECT name , pulse_value FROM capteur ORDER BY user_id DESC LIMIT 1");
$row = $stmt->fetch(PDO::FETCH_ASSOC);

// Envoi des données au format JSON
header('Content-Type: application/json');
echo json_encode($row);
