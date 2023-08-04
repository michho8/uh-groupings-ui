/* global inject */
describe("OutageMessageController", () => {

    beforeEach(module("UHGroupingsApp"));

    let scope;
    let controller;
    let httpBackend;
    let BASE_URL;
    let gs;

    beforeEach(inject(($rootScope, $controller, _BASE_URL_, _$httpBackend_, groupingsService) => {
        scope = $rootScope.$new(true);
        controller = $controller("OutageMessageJsController", {
            $scope: scope
        });
        httpBackend = _$httpBackend_;
        BASE_URL = _BASE_URL_;
        gs = groupingsService;
    }));

    it("should define the outage message controller", () => {
        expect(controller).toBeDefined();
    });

    describe("init", () => {
        it("should call getOutageMessages from groupingsService", () => {
            spyOn(gs, "getOutageMessages").and.callThrough();
            scope.init();
            expect(gs.getOutageMessages).toHaveBeenCalled();
        });
    });
});