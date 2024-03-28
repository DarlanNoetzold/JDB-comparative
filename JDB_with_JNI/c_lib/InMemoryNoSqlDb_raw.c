// InMemoryNoSqlDb.c
#include "Document.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char* dbDirectory = "dbFiles";

void init() {
    // Criar diretório se não existir
    struct stat st = {0};
    if (stat(dbDirectory, &st) == -1) {
        mkdir(dbDirectory, 0700);
    }
}

void saveToFile(const char* id, const char* data) {
    char path[256];
    sprintf(path, "%s/%s.txt", dbDirectory, id);

    FILE* file = fopen(path, "w");
    if (file == NULL) {
        perror("Failed to open file for writing");
        return;
    }

    fprintf(file, "%s", data);
    fclose(file);
}

char* readFromFile(const char* id) {
    char path[256];
    sprintf(path, "%s/%s.txt", dbDirectory, id);

    FILE* file = fopen(path, "r");
    if (file == NULL) {
        perror("Failed to open file for reading");
        return NULL;
    }

    char* data = malloc(1024); // Supondo que os dados do documento sejam menores que 1024 bytes
    if (fgets(data, 1024, file) == NULL) {
        fclose(file);
        free(data);
        return NULL;
    }

    fclose(file);
    return data;
}

void create(const char* id, const char* data) {
    saveToFile(id, data);
}

char* read(const char* id) {
    return readFromFile(id);
}

void update(const char* id, const char* data) {
    saveToFile(id, data); // Simples substituição para atualização
}

void delete(const char* id) {
    char path[256];
    sprintf(path, "%s/%s.txt", dbDirectory, id);
    remove(path);
}

int main() {
    init();
    create("1", "Data for document 1");
    char* data = read("1");
    if (data != NULL) {
        printf("Read data: %s\n", data);
        free(data);
    }
    update("1", "Updated data for document 1");
    delete("1");
    return 0;
}
