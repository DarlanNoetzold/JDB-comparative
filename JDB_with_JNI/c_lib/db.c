#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Simples estrutura para representar um documento
typedef struct {
    char* id;
    char* data; // Supondo que os dados são simplesmente texto por simplicidade
} Document;

// Cria ou atualiza um documento
void createOrUpdateDocument(const char* id, const char* data) {
    char filename[256];
    snprintf(filename, sizeof(filename), "dbFiles/%s.txt", id);
    FILE* file = fopen(filename, "w");
    if (file == NULL) {
        printf("Falha ao abrir o arquivo.\n");
        return;
    }
    fprintf(file, "%s", data);
    fclose(file);
}

// Lê um documento
char* readDocument(const char* id) {
    char filename[256];
    snprintf(filename, sizeof(filename), "dbFiles/%s.txt", id);
    FILE* file = fopen(filename, "r");
    if (file == NULL) {
        printf("Documento não encontrado.\n");
        return NULL;
    }
    fseek(file, 0, SEEK_END);
    long fsize = ftell(file);
    fseek(file, 0, SEEK_SET);

    char *data = (char*)malloc(fsize + 1);
    fread(data, 1, fsize, file);
    fclose(file);
    data[fsize] = 0;

    return data;
}

// Deleta um documento
void deleteDocument(const char* id) {
    char filename[256];
    snprintf(filename, sizeof(filename), "dbFiles/%s.txt", id);
    remove(filename);
}
