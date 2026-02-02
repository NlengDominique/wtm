package fr.univjardinage.jardinage.event;

public record CsvImportEvent(
        int total,
        long durationMs
) {
}
