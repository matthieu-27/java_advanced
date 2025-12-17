# Description textuelle des cas d'utilisations

## Acteurs

- Administrateur : Utilisateur technique avec un accès complet à toutes les fonctionnalités.
- Conseillers bancaires : Employé de la banque qui gère les comptes et les opérations pour les clients.

## Droits d'accès :

- Administrateur : Utilisateur technique avec un accès complet à toutes les fonctionnalités.
- Conseillers bancaires : Employé de la banque qui gère les comptes et les opérations pour les clients.
- 
### Cas d'utilisation 1 :

---

| Elément                       | Description                                                                                                                                                                                                                   |
|-------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| __Nom des cas d’utilisation__ | Cas 1 : Créer un compte bancaire                                                                                                                                                                                              |
| __But / Objectif__            | Permet de créer un nouveau compte bancaire pour un client.                                                                                                                                                                    
| __Acteur principal__          | Admin Système, Conseiller Bancaire.                                                                                                                                                                                           |
| __Préconditions__             | - Le numéro de compte doit être unique et valide (regex). <br /> - Le solde initial doit être positif ou nul.                                                                                                                 
|
| __Scénario principal__        | 1 Saisir le numéro de compte (format FR-XXXX-XXXX).<br /> 2 Saisir le nom du titulaire. <br /> 3 Définir le solde initial (≥ 0). <br /> 4 Choisir le type de compte (standard ou avec plafond). <br /> 5 Valider la création. 
|
| __Scénario alternatif__       | 
|
| __Postconditions__            | - InvalidAccountNumberException : Si le format du numéro est invalide. <br /> - DuplicateAccountException : Si le numéro de compte existe déjà.                                                                                                                                                                                                                       |

### Cas d'utilisation 2 :