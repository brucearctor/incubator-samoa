package org.apache.samoa.evaluation;

/*
 * #%L
 * SAMOA
 * %%
 * Copyright (C) 2014 - 2015 Apache Software Foundation
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.apache.samoa.instances.Instance;
import org.apache.samoa.moa.MOAObject;
import org.apache.samoa.moa.core.Measurement;
import org.apache.samoa.moa.core.Vote;

/**
 * Interface implemented by learner evaluators to monitor the results of the learning process.
 * 
 * @author Richard Kirkby (rkirkby@cs.waikato.ac.nz)
 * @version $Revision: 7 $
 */
public interface PerformanceEvaluator extends MOAObject {

  /**
   * Resets this evaluator. It must be similar to starting a new evaluator from scratch.
   * 
   */
  public void reset();

  /**
   * Adds a learning result to this evaluator.
   * 
   * @param inst
   *          the instance to be classified
   * @param classVotes
   *          an array containing the estimated membership probabilities of the test instance in each class
   * @return an array of measurements monitored in this evaluator
   */
  public void addResult(Instance inst, double[] classVotes, String instanceIdentifier);

  /**
   * Gets the current measurements monitored by this evaluator.
   * 
   * @return an array of measurements monitored by this evaluator
   */
  public Measurement[] getPerformanceMeasurements();

  /**
   * Gets the current votes monitored by this evaluator.
   * 
   * @return an array of votes monitored by this evaluator
   */
  public Vote[] getPredictionVotes();
}
