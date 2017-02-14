call  %~dp011.SetEnv.bat
call  %~dp012.CreateDatabase.bat
mysql -u root -p  lms < %~dp0lms.sql
