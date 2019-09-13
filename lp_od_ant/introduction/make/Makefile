# Ce fichier illustre ce qu'est un Makefile
#
# Appelé avec 
#		make [cible]
# 
# Adapté pour les programmes C et C++ mais les autres comme Java ?
# Portabilité (IDE, OS) ? 
# La manière de fédérer différents outils en un seul processus cohérent ?

# top-level rule to create the program
all : hello

# compiling the source code
hello.o : hello.c
	gcc -g -Wall -c hello.c

# linking the compiled files
hello : hello.o
	gcc -g hello.o -o hello

# remove generated files
clean :
	/bin/rm -f hello hello.o
