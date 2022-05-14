import 'jasmine';
import { actorCalled } from '@serenity-js/core';
import { BrowseTheWeb } from '@serenity-js/protractor';
import { protractor } from 'protractor';
import { OpenTheApp } from './OpenTheApp';

describe('Lighthouse App', () => {
  it('lets us book desks', () =>
    actorCalled('End User')
      .whoCan(BrowseTheWeb.using(protractor.browser))
      .attemptsTo(OpenTheApp()));
});
