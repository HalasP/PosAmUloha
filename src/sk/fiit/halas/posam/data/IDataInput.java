package sk.fiit.halas.posam.data;

import java.io.BufferedReader;
import java.io.IOException;

import sk.fiit.halas.posam.problem.ProblemRepresentation;

public interface IDataInput {

	ProblemRepresentation getProblemRepresentation(BufferedReader bufferedReader) throws IOException;
}
